package com.process.boot;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xkx
 * @description
 */
public class ThreadTest {

  static volatile boolean stop;
  private static final Integer _1M = 1024*1024;

  public static void main(String[] args) throws InterruptedException {
//    Thread subThread = new Thread(new SubThread());
//    System.out.println("主线程进行");
//    subThread.start();
//    Thread.sleep(1000L);
//    subThread.interrupt();
    byte[] allocation1, allocation2,allocation3,allocation4,allocation5,
        allocation6,allocation7,allocation8,allocation9;
    allocation1 = new byte[2*_1M];
    allocation2 = new byte[2*_1M];
    allocation3 = new byte[3*_1M];
    allocation4 = new byte[4*_1M];
    allocation5 = new byte[1*_1M];
//    allocation6 = new byte[1*_1M];

//    allocation7 = new byte[2*_1M];
//    allocation8 = new byte[2*_1M];
    //allocation2 = new byte[900*1024];


  }

//  static class SubThread implements Runnable {
//
//    @Override
//    public void run() {
//      try {
//        Thread.sleep(5000L);
//      } catch (InterruptedException e) {
//        System.out.println("线程睡眠,处于阻塞状态时被中断,抛出异常:" + e);
//        System.out.println("线程的中断状态:" + Thread.currentThread().isInterrupted());
//        Thread.currentThread().interrupt();
//        System.out.println("保留中断状态");
//      }
//      System.out.println("执行这句话");
//    }
//  }
}
