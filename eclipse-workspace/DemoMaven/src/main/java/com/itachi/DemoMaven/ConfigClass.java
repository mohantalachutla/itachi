package com.itachi.DemoMaven;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.itachi.DemoMaven.model.Name;

@Configuration
@ComponentScan(value={"com.itachi.DemoMaven"})
public class ConfigClass {

	/*
	 * @Bean("nameee") public Name getNamebean() { return new Name(); }
	 */
}
