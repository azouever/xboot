package com.process.xboot.lock;

/**
 * @author Kai
 * @description do something
 */
public class SynchronizedJavaPTest {

  private static Integer amount;

  public static void amountInc() {
    synchronized (SynchronizedTest.class) {
      amount++;
      publishEvent();
    }
  }

  private static synchronized void publishEvent() {
    System.out.println("amount added successful");
  }

}
