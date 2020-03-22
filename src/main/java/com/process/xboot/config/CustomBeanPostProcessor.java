package com.process.xboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xkx
 * @description
 */
@Slf4j
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {


  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
//    System.out.println("bean初始化方法调用前被调用");
//    System.out.println(bean);
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//    System.out.println("bean初始化方法调用后被调用");
//    System.out.println(bean);
    return bean;
  }
}
