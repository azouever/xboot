package com.process.xboot.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xkx
 * @description ServletContextListener 监听器测试
 */
@Order(0)
@Component
public class XbootServletContextListener0 implements ServletContextListener {

  /**
   * * Notification that the web application initialization process is starting. All
   * ServletContextListeners are notified of context initialization before any filter or servlet in
   * the web application is initialized. The default implementation is a NO-OP.
   *
   * @param sce Information about the ServletContext that was initialized
   */
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("XBOOT 监听到 ServletContext 0 初始化");
  }

  /**
   * * Notification that the servlet context is about to be shut down. All servlets and filters have
   * been destroy()ed before any ServletContextListeners are notified of context destruction. The
   * default implementation is a NO-OP.
   *
   * @param sce Information about the ServletContext that was destroyed
   */
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("XBOOT 监听到 ServletContext 0 销毁");
  }
}
