package com.process.xboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author xkx
 */
@SpringBootApplication
@MapperScan(basePackages = "com.process.boot.mapper")
@EntityScan(basePackages = "com.process.boot.entity")
public class XbootApplication {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(XbootApplication.class);
    //application.setBannerMode(Mode.OFF);
    ConfigurableApplicationContext applicationContext = application.run(args);
  }

}
