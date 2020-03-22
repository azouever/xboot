package com.process.xboot.lock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 * @description do something
 */
public class LockTest {

  private static final Logger log = LoggerFactory.getLogger(LockTest.class);
  private final static ThreadMXBean mbean = ManagementFactory
      .getThreadMXBean();
  public static ReentrantLock lock = new ReentrantLock();
  public static Condition condition = lock.newCondition();
  public Integer num;

  public void numDesForCondition() {
    lock.lock();
    try {
      condition.await();
      num += 10;
    } catch (Exception e) {
      log.error(e.getMessage());
    } finally {
      lock.unlock();
    }

  }

  public void numDes() {
    lock.lock();
    try {
      num++;
      if (num == 6) {
        condition.signal();
      }
    } catch (Exception e) {
      log.error(e.getMessage());
    } finally {
      lock.unlock();
    }

  }
}
