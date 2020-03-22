package com.process.xboot.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * @author xkx
 * @description
 */
public class AtomicTest {

  private static final Integer COUNT = 10000;
  private static AtomicInteger ai = new AtomicInteger(0);

  @Test
  public void test() throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(30);
    for (Integer i = 0; i < COUNT; i++) {
      executorService.execute(new customTask());
    }
    int sum = 0;
    while (true){
      Thread.sleep(50);
      int i = ai.get();
      if(i == sum){
        break;
      }
      sum = i;
    }
    System.out.println(ai.get());
  }


  class customTask implements Runnable{
    @Override
    public void run() {
      ai.getAndIncrement();
      if(ai.get() == 5000){
        throw new RuntimeException("异步线程发生异常");
      }
    }
  }
}
