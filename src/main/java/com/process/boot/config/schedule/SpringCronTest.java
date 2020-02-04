package com.process.boot.config.schedule;

import cn.hutool.core.date.DatePattern;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author xkx
 * @description do something
 */
@Component
public class SpringCronTest {

  private static final Logger log = LoggerFactory.getLogger(SpringCronTest.class);

  //@Scheduled(cron = "*/5 * * * * *")
  public void secondTestExecute() {
    log.info("every 5 seconds execute task，now:{}",
        LocalDateTime.now().format(DateTimeFormatter.ofPattern(
            DatePattern.NORM_DATETIME_PATTERN)));

  }

}
