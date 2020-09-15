package com.itachi.ekart.order.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.itachi.ekart.order.model.OrderDetails;

@SpringBootConfiguration
@EnableAutoConfiguration
public class Utility {

	@Bean
	public Map<String, Object> getSringObjectMapBean() {

		return new HashMap<String, Object>();
	}

	@Bean
	public List<OrderDetails> getOrderDetailListBean() {

		return new ArrayList<OrderDetails>();
	}

	@Bean
	public List<String> getStringListBean() {

		return new ArrayList<String>();
	}

	@Bean
	public List<Object> getObjectListBean() {

		return new ArrayList<Object>();
	}
}
