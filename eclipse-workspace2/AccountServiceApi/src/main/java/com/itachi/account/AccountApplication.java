package com.itachi.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itachi.account.controller.Controller;

@SpringBootApplication
@Configuration
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
		
	}
	/*
	 * @Bean public Logger getLoggerBean() { return
	 * LoggerFactory.getLogger(Controller.class); }
	 */

}
