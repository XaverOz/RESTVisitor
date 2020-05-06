package com.xvrozz.testvisitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RestVisitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestVisitorApplication.class, args);
	}

}
