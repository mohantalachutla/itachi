package com.itachi.ekart.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableEurekaClient

@EnableDiscoveryClient
@SpringBootApplication
public class EkartOrderiApplication {
	public static void main(String[] args) {
		SpringApplication.run(EkartOrderiApplication.class, args);
		Logger logger = LoggerFactory.getLogger(EkartOrderiApplication.class);
		logger.debug("OrderServiceApplication has been initialized");
	}

}
