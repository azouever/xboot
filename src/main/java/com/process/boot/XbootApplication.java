package com.process.boot;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xkx
 */
@SpringBootApplication
public class XbootApplication {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(XbootApplication.class);
    application.setBannerMode(Mode.OFF);
    application.run(args);
//    SpringApplication.run(XbootApplication.class, args);
  }

}
