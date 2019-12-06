package com.process.boot.config.schedule;

import java.util.Date;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author xkx
 * @description
 */

public class QuartzTest extends QuartzJobBean {

  private final Logger log = LoggerFactory.getLogger(getClass());
  @Override
  protected void executeInternal(JobExecutionContext jobExecutionContext)
      throws JobExecutionException {
    System.out.println(jobExecutionContext);
    System.out.println("quartz task " + new Date());
  }
}
