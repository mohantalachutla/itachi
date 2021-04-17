package com.itachi.ekart.gateway;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@EnableAutoConfiguration
public class GateWayRouter {

	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder rBuilder) {
		// @formatter:off
		return rBuilder.routes(). //returns AsyncBuilder
					// router for order-service
					route("order-service", 
							r -> r.path("/order/**")
							.uri("http://localhost:5003/")
						)
					// router for payment-service
					.route("payment-service", 	// Function<Predicate,AsyncBuilder>
							r -> r.path("/payment/**") //Predicate<ServerHttpRequest>
							.uri("lb://PAYMENT-SERVICE/")
						)
					//.route("gatway-test",  r -> r.path("/gateway/**").uri("lb://EKART-GATEWAY"))
					
					// returns RouteLocator
					.build();

		// @Formatter:on
	}
}
