package com.process.xboot.config.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class TimerTest {

  private final Logger log = LoggerFactory.getLogger(getClass());

  public static void main(String[] args) {
    TimerTask timerTask = new CustomTimerTask();
    Timer timer = new Timer();
     timer.schedule(timerTask,new Date(),3000);
  }


  static class CustomTimerTask extends TimerTask {

    @Override
    public void run() {
      System.out.println("定时任务执行。。。"+System.currentTimeMillis());
    }
  }
}
