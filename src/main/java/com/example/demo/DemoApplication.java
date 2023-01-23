package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		//context = SpringApplication.run(DemoApplication.class, args);
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		Employee e = context.getBean(Employee.class);
		System.out.println(e);
		*/
		SpringApplication.run(DemoApplication.class, args);

	}
}
