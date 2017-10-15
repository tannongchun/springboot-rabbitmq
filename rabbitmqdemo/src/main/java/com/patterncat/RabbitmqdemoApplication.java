package com.patterncat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.patterncat")
public class RabbitmqdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqdemoApplication.class, args);
	}

}
