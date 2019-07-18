package com.process.boot;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xkx
 * @description
 */
public class ThreadTest {

  static volatile boolean stop;

  public static void main(String[] args) throws InterruptedException {
    System.out.println("你好");
//    Thread subThread = new Thread(new SubThread());
//    System.out.println("主线程进行");
//    subThread.start();
//    Thread.sleep(1000L);
//    subThread.interrupt();

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
