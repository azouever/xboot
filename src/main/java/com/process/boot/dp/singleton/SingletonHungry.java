package com.process.boot.dp.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description 饿汉式, 就是只要类加载, 那么该对象就会创建
 */
public class SingletonHungry {

  private static final Logger log = LoggerFactory.getLogger(SingletonHungry.class);

  private static SingletonHungry singletonHungry = new SingletonHungry();

  private SingletonHungry() {
  }

  public static SingletonHungry getInstance() {
    return singletonHungry;
  }
}
