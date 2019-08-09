package com.process.boot.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;


/**
 * @author xkx
 * @description applicationContext初始化测试
 */
@Order(10)
public class XbootApplicationContextInitializer implements ApplicationContextInitializer {

  /**
   * Initialize the given application context.
   *
   * @param applicationContext the application to configure
   */
  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
//    System.out.println("===============================");
//    System.out.println(applicationContext);
//    System.out.println("applicationContext初始化");
//    System.out.println("===============================");
  }
}
