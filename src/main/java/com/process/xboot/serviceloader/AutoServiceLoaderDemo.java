package com.process.xboot.serviceloader;

import java.util.ServiceLoader;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class AutoServiceLoaderDemo {

  private static final Logger log = LoggerFactory.getLogger(AutoServiceLoaderDemo.class);

  public static void main(String[] args) {
    ReentrantLock reentrantLock = new ReentrantLock();
    ServiceLoader<Say> says = ServiceLoader.load(Say.class);
    for (Say say : says) {
      say.say();
    }
  }
}
