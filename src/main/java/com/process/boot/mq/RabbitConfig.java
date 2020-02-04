package com.process.boot.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xukaixuan
 */
@Configuration
public class RabbitConfig {

  private static final String TASK_ROUTING_KEY = "xboot.pay.task";
  private static final String STATUS_ROUTING_KEY = "xboot.pay.status";

  @Bean
  public Queue queueNew() {
    return new Queue("xboot.new");
  }

  @Bean
  public Queue queuePayTask() {
    return new Queue(RabbitConfig.TASK_ROUTING_KEY);
  }

  @Bean
  public Queue queuePayStatus() {
    return new Queue(RabbitConfig.STATUS_ROUTING_KEY);
  }

  @Bean
  public DirectExchange xbootPayExchange(){
    return new DirectExchange("xboot.pay", true, false);
  }

  @Bean
  public DirectExchange testDeclareExchange() {
    return new DirectExchange("xboot.test.declare", true, false);
  }
    @Bean
  public Binding bindingPay(){
    return BindingBuilder.bind(queuePayTask()).to(xbootPayExchange())
        .with(RabbitConfig.TASK_ROUTING_KEY);
  }
}