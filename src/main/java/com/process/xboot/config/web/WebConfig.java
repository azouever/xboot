package com.process.xboot.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Kai
 */
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        // 最好指明指定的 origin
//            .allowedOrigins("http://localhost:3000/new")
        .allowedOrigins("*")
        //是否允许证书 不再默认开启
        .allowCredentials(true)
        .allowedHeaders("*")
        //设置允许的方法
        .allowedMethods("*")
        //跨域允许时间
        .maxAge(36000);
  }


  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**")
            .addResourceLocations("classpath:/static/");
  }

  @Bean
  public InternalResourceViewResolver defaultViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/");
    resolver.setSuffix(".html");
    return resolver;
  }
}