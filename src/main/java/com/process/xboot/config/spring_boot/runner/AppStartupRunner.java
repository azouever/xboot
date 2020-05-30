package com.process.xboot.config.spring_boot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class AppStartupRunner implements ApplicationRunner {

  private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

  @Override
  public void run(ApplicationArguments args) throws Exception {
    try {
      logger.info("-----------------------------------------------------------------");
      logger.info("-----------------------------------------------------------------");
      logger.info("---------------xboot----application----started-------------------");
      logger.info("-----------------------------------------------------------------");
      logger.info("-----------------------------------------------------------------");
    } catch (Exception e) {
      logger.error("custom runner exception", e);
    }
  }
}