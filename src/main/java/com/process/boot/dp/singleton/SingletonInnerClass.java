package com.process.boot.dp.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description 通过内部类的形式
 */
public class SingletonInnerClass {

  private static final Logger log = LoggerFactory.getLogger(SingletonInnerClass.class);


  private static class Holder {

    static {
      log.info("inner class loaded");
    }

    private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
  }

  private SingletonInnerClass() {
  }

  public static final SingletonInnerClass getInstance() {
    return Holder.INSTANCE;
  }

  public static void main(String[] args) {
    SingletonInnerClass singletonInnerClass = new SingletonInnerClass();
  }
}
