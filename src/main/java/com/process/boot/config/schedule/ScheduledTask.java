package com.process.boot.config.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author xkx
 * @description
 */
@Component
@EnableScheduling
public class ScheduledTask {

  private final Logger log = LoggerFactory.getLogger(getClass());

  //	 * on the second as well as minute, hour, day of month, month and day of week.
  //	 * <p>E.g. {@code "0 * * * * MON-FRI"} means once per minute on weekdays
  //	 * (at the top of the minute - the 0th second).
  //@Scheduled(cron = "30 * * * * ?")
  private void execute() {
    System.out.println("通过注解让定时任务执行" + System.currentTimeMillis());
  }
}
