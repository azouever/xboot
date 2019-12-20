package com.process.boot.datetime;

import java.time.LocalDate;
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
    System.err.println("date time now");
  }

}
