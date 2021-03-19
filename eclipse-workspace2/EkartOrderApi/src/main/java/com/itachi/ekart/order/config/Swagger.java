package com.itachi.ekart.order.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootConfiguration
@EnableSwagger2
@RefreshScope
public class Swagger {

	@Bean
	public Docket getOpenApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("itachi").apiInfo(getApiInfo()).select()
				.paths(PathSelectors.any()).build(); // generates documentation for all controller endpoints, use regex
														// for specific
	}

	public ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Order service").description("Order service for Ekart").version("1.0").build();
	}
}
