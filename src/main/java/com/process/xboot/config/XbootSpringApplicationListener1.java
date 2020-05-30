package com.process.xboot.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * @author xkx
 * @description SpringApplicationListener 监听器测试
 */
@Component
public class XbootSpringApplicationListener1 implements ApplicationListener {

  /**
   * Handle an application event.
   *
   * @param event the event to respond to
   */
  @Override
  public void onApplicationEvent(ApplicationEvent event) {
    System.out.println(Thread.currentThread().getName());
    System.out.println(event.toString());
    System.out.println("XBOOT自定义监听器==1==响应事件");
  }
}
