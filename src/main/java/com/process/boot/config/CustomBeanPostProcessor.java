package com.process.boot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author xkx
 * @description
 * @since 2019/4/4 10:56
 */
@Slf4j
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {


  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    log.error("+++++++++ postProcessBeforeInitialization 被调用了  ++++ 开始  ++++++++++++++++++");
    System.out.println("bean初始化方法调用前被调用");
    System.out.println(bean);
    log.error("+++++++++ postProcessBeforeInitialization 被调用了  ++++ 结束 +++++++++++++++++");
    return null;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    log.error("+++++++++ postProcessAfterInitialization被调用了  ++++ 开始  ++++++++++++++++++");
    System.out.println("bean初始化方法调用后被调用");
    System.out.println(bean);
    log.error("+++++++++ postProcessAfterInitialization被调用了 +++++ 结束 +++++++++++++++++");
    return null;
  }
}
