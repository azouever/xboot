package com.process.xboot.lock;

import com.process.xboot.lock.Task.AddTask;
import com.process.xboot.lock.Task.UpdateTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class SynchronizedTest {

  private static AtomicInteger atomicInteger = new AtomicInteger(0);

  private final Logger log = LoggerFactory.getLogger(getClass());

  final Object lock = new Object();

  private static volatile boolean locked = true;

  static {
    System.out.println("我是静态代码块");
  }

  public static void saveBill() {
    while (locked) {
      System.out.println("我被阻塞了");
    }
    synchronized (SynchronizedTest.class) {
      System.out.println("我获取到锁了");
      System.out.println("添加账单");
    }
  }

  public static synchronized void updateBill() {
    try {
      locked = true;
      Thread.sleep(3000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("更新账单");
    locked = false;
  }

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    executorService.execute(new UpdateTask());
    executorService.execute(new AddTask());
  }
}
