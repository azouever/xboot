package com.process.xboot.config;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;


/**
 * @author xkx
 * @description SpringApplicationRunListener 监听器测试
 */
@Order(0)
@Component
public class XbootSpringApplicationRunListener0 implements SpringApplicationRunListener {

  /**
   * Called immediately when the run method has first started. Can be used for very early
   * initialization.
   */
  @Override
  public void starting() {
    System.out.println("XbootSpringApplicationRun监听器==0== 表明spring应用开始启动");
  }

  /**
   * Called once the environment has been prepared, but before the {@link ApplicationContext} has
   * been created.
   *
   * @param environment the environment
   */
  @Override
  public void environmentPrepared(ConfigurableEnvironment environment) {

  }

  /**
   * Called once the {@link ApplicationContext} has been created and prepared, but before sources
   * have been loaded.
   *
   * @param context the application context
   */
  @Override
  public void contextPrepared(ConfigurableApplicationContext context) {
    System.out.println("context准备0");
  }

  /**
   * Called once the application context has been loaded but before it has been refreshed.
   *
   * @param context the application context
   */
  @Override
  public void contextLoaded(ConfigurableApplicationContext context) {

  }

  /**
   * The context has been refreshed and the application has started but {@link CommandLineRunner
   * CommandLineRunners} and {@link ApplicationRunner ApplicationRunners} have not been called.
   *
   * @param context the application context.
   * @since 2.0.0
   */
  @Override
  public void started(ConfigurableApplicationContext context) {

  }

  /**
   * Called immediately before the run method finishes, when the application context has been
   * refreshed and all {@link CommandLineRunner CommandLineRunners} and {@link ApplicationRunner
   * ApplicationRunners} have been called.
   *
   * @param context the application context.
   * @since 2.0.0
   */
  @Override
  public void running(ConfigurableApplicationContext context) {

  }

  /**
   * Called when a failure occurs when running the application.
   *
   * @param context the application context or {@code null} if a failure occurred before the context
   * was created
   * @param exception the failure
   * @since 2.0.0
   */
  @Override
  public void failed(ConfigurableApplicationContext context, Throwable exception) {

  }
}
