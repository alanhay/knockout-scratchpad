package com.certait.knockout;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.certait.knockout.filter.UIConfigFilter;

@Configuration
public class KnockoutConfig {

	@Bean
	public FilterRegistrationBean<UIConfigFilter> uiConfigFilter() {
		FilterRegistrationBean<UIConfigFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new UIConfigFilter());
		registrationBean.addUrlPatterns(new String[] { "/", "/update" });

		return registrationBean;
	}
}
