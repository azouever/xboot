package com.process.xboot.config.spring_boot.runner;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Order(1)
@Component
public class AppStartupRunner implements ApplicationRunner {

  private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

  private List<WebMvcConfigurer> configurers = new ArrayList<>();


  @Autowired(required = false)
  public void setConfigurers(List<WebMvcConfigurer> configurers) {
    if (!CollectionUtils.isEmpty(configurers)) {
      this.configurers.addAll(configurers);
    }
  }

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