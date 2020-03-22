package com.process.xboot.git;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 * @description do something
 */
public class ListenerFeatureDemo {

  private static final Logger log = LoggerFactory.getLogger(ListenerFeatureDemo.class);

  public static void main(String[] args) {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
    executorService.schedule(new AsyncTask(), 5, TimeUnit.SECONDS);
    executorService.execute(new AsyncTask());
  }

  static class AsyncTask implements Runnable {

    @Override
    public void run() {
      log.info("async task execute begin");
      log.info("async task executing.....");
      log.info("async task execute end");
    }
  }
}
