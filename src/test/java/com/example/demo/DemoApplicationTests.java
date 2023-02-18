package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class DemoApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		String[] beans = context.getBeanDefinitionNames();
		//Arrays.stream(beans).forEach(i->System.out.println("===== "+ i));
	}

}
