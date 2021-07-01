package com.ms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ms.util.MobileUtil;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public MobileUtil mobileUtil() {
		return new MobileUtil();
		
	}

}
