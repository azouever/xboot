package com.process.xboot.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xkx
 * @description
 */
public class RocketsCond implements Condition {

  @Override
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {

//    for (String name : conditionContext.getRegistry().getBeanDefinitionNames()) {
//      System.out.println(name);
//    }
//    System.out.println(conditionContext.getBeanFactory().containsBean("xbootApplicationContextInitializer")
//        + "/" + metadata.isAnnotated(Order.class.getName()));

    return false;
  }
}
