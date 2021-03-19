package com.itachi.ekart.payment.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootConfiguration
public class PaymentBeanFactory {
	@Bean
	@ConfigurationProperties("app.datasource")
	public HikariDataSource getHikariDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).driverClassName("org.postgresql.Driver").build();
	}
}
