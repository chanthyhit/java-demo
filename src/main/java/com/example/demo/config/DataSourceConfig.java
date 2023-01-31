package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Profile("local")
    @PropertySource("classpath:application-local.properties")
    class Local {
        @Value("${spring.datasource.jndi-name}")
        private String jndiName;
        @Value("${spring.jpa.database-platform}")
        private String platform;
        @Bean
        public DataSource jndiDataSource() throws NamingException {
            JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
            bean.setJndiName(jndiName);
            bean.setProxyInterface(DataSource.class);
            bean.setLookupOnStartup(false);
            bean.afterPropertiesSet();
            return (DataSource) bean.getObject();
        }
        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
            LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactory.setDataSource(jndiDataSource());
            entityManagerFactory.setPersistenceUnitName("MySQL");
            entityManagerFactory.setPackagesToScan(new String[]{"com.example.demo.pojo"});
            entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
            entityManagerFactory.setJpaProperties(jpaProperties());
            return entityManagerFactory;
        }
        @Bean
        public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
            return new JpaTransactionManager(entityManagerFactory);
        }
        private Properties jpaProperties() {
            Properties properties = new Properties();
            properties.put("hibernate.dialect", platform);
            properties.put("hibernate.show_sql", true);
            return properties;
        }
    }

    @Profile("dev")
    @PropertySource("classpath:application-dev.properties")
    class Dev {
        @Value("${spring.jpa.database-platform}")
        private String platform;
        @Value("${spring.datasource.driverClassName}")
        private String driverClassName;
        @Value("${spring.datasource.url}")
        private String url;
        @Value("${spring.datasource.username}")
        private String username;
        @Value("${spring.datasource.password}")
        private String password;

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        }
        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactory.setDataSource(dataSource());
            entityManagerFactory.setPersistenceUnitName("MySQL");
            entityManagerFactory.setPackagesToScan(new String[]{"com.example.demo.pojo"});
            entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
            entityManagerFactory.setJpaProperties(jpaProperties());
            return entityManagerFactory;
        }
        @Bean
        public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
            return new JpaTransactionManager(entityManagerFactory);
        }
        private Properties jpaProperties() {
            Properties properties = new Properties();
            properties.put("hibernate.dialect", platform);
            properties.put("hibernate.show_sql", true);
            return properties;
        }
    }

/*
    //@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("password");
        return dataSource;
    }


    private void initialize() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("schema.sql"));
        populator.addScript(new ClassPathResource("data.sql"));
        DatabasePopulatorUtils.execute(populator, dataSource());
    }*/

}

