package com.itachi.ekart.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
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
