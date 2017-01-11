package com.hsbc.common.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hsbc.common.logger.LogServletFilter;



@Configuration
public class ServletFilterConfiguration 
{
	@Autowired
	private Environment props;	

	@Bean(name="logServletFilter")
    FilterRegistrationBean addLogFilter()
    {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LogServletFilter(props.isLogPayload()));
        registration.addUrlPatterns("/*");
        registration.setName("logServletFilter");
        registration.setOrder(1);
        return registration;
    }
}
