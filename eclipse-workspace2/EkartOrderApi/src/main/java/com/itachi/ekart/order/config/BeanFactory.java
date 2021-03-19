package com.itachi.ekart.order.config;

import java.time.Duration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
@RefreshScope
public class BeanFactory {

	@Bean
	@LoadBalanced
	public RestTemplate getRetTemplate(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(Duration.ofSeconds(5)).setReadTimeout(Duration.ofSeconds(5)).build();
	}

	@Bean
	public HttpHeaders getHttpHeaders() {
		return new HttpHeaders();
	}
}
