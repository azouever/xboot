package com.process.xboot.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class WebConfig
    implements WebMvcConfigurer {

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
}