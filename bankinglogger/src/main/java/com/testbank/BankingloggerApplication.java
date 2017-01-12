package com.testbank;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import com.hsbc.common.annotation.ApplicationService;

@ApplicationService
@ComponentScan(basePackages = {"com.testbank.controller"})
public class BankingloggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingloggerApplication.class, args);
	}
}
