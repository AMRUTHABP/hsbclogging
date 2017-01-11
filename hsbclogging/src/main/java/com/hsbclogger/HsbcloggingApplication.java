package com.hsbclogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.logger.controller" })
public class HsbcloggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HsbcloggingApplication.class, args);
	}
}
