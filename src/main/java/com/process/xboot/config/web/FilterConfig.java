package com.process.xboot.config.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * filter配置
 */
//@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean companyUrlFilterRegister() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    //注入过滤器
//        registration.setFilter(new TestFilter1());
    //拦截规则
    registration.addUrlPatterns("/*");
    //过滤器名称
    registration.setName("testFilter1");
    //过滤器顺序
    registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
    return registration;
  }

  @Bean
  public FilterRegistrationBean outLinkSecurityFilterRegister() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    //注入过滤器
//        registration.setFilter(new TestFilter2());
    //拦截规则
    registration.addUrlPatterns("/*");
    //过滤器名称
    registration.setName("testFilter2");
    //过滤器顺序
    registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE - 1);
    return registration;
  }

}