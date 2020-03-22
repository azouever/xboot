package com.process.xboot.config.schedule;

import java.security.InvalidParameterException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class ExecutorScheduledServiceTest {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final static AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

  public static void main(String[] args) {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
    scheduledExecutorService
        .scheduleWithFixedDelay(new CustomScheduleTask(), 0, 2000, TimeUnit.MILLISECONDS);
  }

  static class CustomScheduleTask implements Runnable {

    @Override
    public void run() {
      try {
        ATOMIC_INTEGER.getAndIncrement();
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName());
        System.out.println(ATOMIC_INTEGER);
        if (ATOMIC_INTEGER.get() == 5) {
          throw new InvalidParameterException("数据异常");
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("定时任务执行。。。" + System.currentTimeMillis());
    }
  }
}
