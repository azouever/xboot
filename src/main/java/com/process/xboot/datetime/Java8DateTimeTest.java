package com.process.xboot.datetime;

import java.time.LocalDate;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description do something
 */
public class Java8DateTimeTest {

  private static final Logger log = LoggerFactory.getLogger(Java8DateTimeTest.class);

  public static void main(String[] args) {
    log.info("test java 8 date time operate api");
    log.info("today date : {}", LocalDate.now());
    // 为什么会写下面这行呢 因为看linux 输出 stdout stderr 的时候 就想看一下这个
    System.err.println("date time now");

    //
    log.info("============show System properties=============");
    Properties properties = System.getProperties();
    properties.stringPropertyNames().forEach(propertyName -> {
      String propertyValue = properties.getProperty(propertyName);
      log.info("properties 中 ========>{}<========属性对应的值是=========>{}<==========", propertyName, propertyValue);
    });
  }

}
