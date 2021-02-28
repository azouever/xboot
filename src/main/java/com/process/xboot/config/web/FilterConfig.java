package com.process.xboot.config.web;

import com.process.xboot.config.web.filter.ReqBodyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * filter配置
 */
@Configuration
public class FilterConfig {

  @Autowired
  private ReqBodyFilter reqBodyFilter;

  @Bean
  public FilterRegistrationBean<ReqBodyFilter> companyUrlFilterRegister() {
    FilterRegistrationBean<ReqBodyFilter> registration = new FilterRegistrationBean();
    //注入过滤器
    registration.setFilter(reqBodyFilter);
    //拦截规则
    registration.addUrlPatterns("/test/form");
    //过滤器名称
    registration.setName("reqBodyFilter");
    //过滤器顺序
    registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
    return registration;
  }

}