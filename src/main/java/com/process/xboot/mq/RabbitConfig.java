package com.process.xboot.mq;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory.CacheMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Configuration;

/**
 * @author xukaixuan
 */
@Configuration
public class RabbitConfig {

  private static final String TASK_ROUTING_KEY = "xboot.pay.task";
  private static final String STATUS_ROUTING_KEY = "xboot.pay.status";

  //@Bean
  //public MessageConverter messageConvert() {
  //return new Jackson2JsonMessageConverter();
  //}


  //@Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
    cachingConnectionFactory.setHost("localhost");
    cachingConnectionFactory.setUsername("admin");
    cachingConnectionFactory.setPassword("123456");
    cachingConnectionFactory.setPort(5672);
    cachingConnectionFactory.setCacheMode(CacheMode.CHANNEL);
    cachingConnectionFactory.setPublisherConfirms(true);
    return cachingConnectionFactory;
  }


  //@Bean(name = "rabbitListenerContainerFactory")
  public SimpleRabbitListenerContainerFactory listenerContainer(
      ConnectionFactory connectionFactory) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    // 手动确认模式
    factory.setConnectionFactory(connectionFactory);
    factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
    // this.queue = new LinkedBlockingQueue<Delivery>(prefetchCount);
    factory.setPrefetchCount(2);
    // 消费者执行，每次从队列中获取prefetchCount数量的消息，放在消费者BlockingQueue中
    factory.setConcurrentConsumers(5);
    factory.setDefaultRequeueRejected(false);
    //factory.setTransactionManager();
    return factory;
  }

  //@Bean
  public RabbitAdmin rabbitAdmin(ConnectionFactory factory) {
    RabbitAdmin admin = new RabbitAdmin(factory);
    admin.setAutoStartup(true);
    return admin;
  }

//
//  @Bean
//  public Queue queueNew() {
//    return new Queue("xboot.new");
//  }
//
//  @Bean
//  public Queue queuePayTask() {
//    return new Queue(RabbitConfig.TASK_ROUTING_KEY);
//  }
//
//  @Bean
//  public Queue queuePayStatus() {
//    return new Queue(RabbitConfig.STATUS_ROUTING_KEY);
//  }
//
//  @Bean
//  public DirectExchange xbootPayExchange() {
//    return new DirectExchange("xboot.pay", true, false);
//  }
//
//  @Bean
//  public DirectExchange testDeclareExchange() {
//    return new DirectExchange("xboot.test.declare", true, false);
//  }
//
//  @Bean
//  public Binding bindingPay() {
//    return BindingBuilder.bind(queuePayTask()).to(xbootPayExchange())
//        .with(RabbitConfig.TASK_ROUTING_KEY);
//  }
}