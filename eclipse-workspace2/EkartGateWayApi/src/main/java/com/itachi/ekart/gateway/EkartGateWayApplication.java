package com.itachi.ekart.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class EkartGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartGateWayApplication.class, args);
	}
	
	/*
	 * @Bean public SecurityWebFilterChain securityWebFilterChain(
	 * ServerHttpSecurity http) { return http.authorizeExchange()
	 * .pathMatchers("/actuator/**").permitAll() .anyExchange().authenticated()
	 * .and().build(); }
	 */
}
