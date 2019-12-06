package com.process.boot.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xkx
 * @description
 */
public class ThunderCond implements Condition {

  @Override
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
    return true;
  }
}
