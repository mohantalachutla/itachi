package com.itachi.ekart.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
public class EkartPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartPaymentApplication.class, args);
	}
}
