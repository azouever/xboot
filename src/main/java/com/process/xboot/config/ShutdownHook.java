package com.process.xboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class ShutdownHook implements Runnable {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Override
  public void run() {
    System.out.println("虚拟机关闭时动作执行");
  }
}
