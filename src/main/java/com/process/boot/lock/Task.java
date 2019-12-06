package com.process.boot.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class Task {

  private final Logger log = LoggerFactory.getLogger(getClass());

   static class AddTask implements Runnable{

    @Override
    public void run() {
      SynchronizedTest synchronizedTest = new SynchronizedTest();
      synchronizedTest.saveBill();
    }
  }

   static class UpdateTask implements Runnable{

    @Override
    public void run() {
      SynchronizedTest.updateBill();
    }
  }
}
