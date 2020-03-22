package com.process.xboot.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.process.xboot.entity.BallTeam;
import com.rabbitmq.client.Channel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.config.DirectRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Reference;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Kai
 * @description do something
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTest {

  private static final Logger log = LoggerFactory.getLogger(RabbitmqTest.class);


  public static final String BUSINESS_EXCHANGE_NAME = "dead.letter.demo.simple.business.exchange";
  public static final String BUSINESS_QUEUEA_NAME = "dead.letter.demo.simple.business.queuea";
  public static final String BUSINESS_QUEUEB_NAME = "dead.letter.demo.simple.business.queueb";
  public static final String DEAD_LETTER_EXCHANGE = "xboot.dead.letter.direct.by.rabbitAdmin";
  public static final String DEAD_LETTER_QUEUE_ZPL_ROUTING_KEY = "dead.letter.queue.zpl.routingkey";
  public static final String DEAD_LETTER_QUEUEB_ROUTING_KEY = "dead.letter.demo.simple.deadletter.queueb.routingkey";
  public static final String DEAD_LETTER_QUEUEA_NAME = "dead.letter.demo.simple.deadletter.queuea";
  public static final String DEAD_LETTER_QUEUEB_NAME = "dead.letter.demo.simple.deadletter.queueb";

  @Autowired
  private RabbitAdmin rabbitAdmin;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory;

  @Reference
  private DirectRabbitListenerContainerFactory directRabbitListenerContainerFactory;

  @Test
  public void rabbitAdminAddExchangeTest() {
    log.info("declare a fanout exchange by admin start===========");
    rabbitAdmin.declareExchange(new FanoutExchange("xboot.fanout.by.rabbitAdmin", true, false));
    log.info("declare a fanout exchange by admin end===========");
  }

  @Test
  public void rabbitAdminAddDirectExchangeTest() {
    log.info("declare a direct exchange by admin start===========");
    HashMap<Object, Object> map = Maps.newHashMapWithExpectedSize(1);
    rabbitAdmin.declareExchange(new DirectExchange("xboot.direct.by.rabbitAdmin", true, false));
    log.info("declare a direct exchange by admin end===========");
  }

  @Test
  public void rabbitAdminAddDeadLetterExchangeTest() {
    log.info("declare a dead letter direct exchange by admin start===========");
    rabbitAdmin.declareExchange(
        new DirectExchange("xboot.dead.letter.direct.by.rabbitAdmin", true, false));
    log.info("declare a dead letter direct exchange by admin end===========");
  }

  @Test
  public void rabbitAdminDeleteExchangeTest() {
    log.info("delete a fanout exchange by admin start===========");
    rabbitAdmin.deleteExchange("xboot.fanout.by.rabbitAdmin");
    log.info("delete a fanout exchange by admin end===========");
  }

  @Test
  public void rabbitAdminAddQueueTest() {
    log.info("declare a queue by admin start===========");
    String queue_xkx = rabbitAdmin
        .declareQueue(QueueBuilder.durable("xboot.queue_hn_xkx.by.rabbitAdmin").build());
    log.info("queue declare result:{}", queue_xkx);
    String queue_ytt = rabbitAdmin
        .declareQueue(QueueBuilder.durable("xboot.queue_hn_ytt.by.rabbitAdmin").build());
    log.info("queue declare result:{}", queue_ytt);
    String queue_flx = rabbitAdmin
        .declareQueue(QueueBuilder.durable("xboot.queue_hn_flx.by.rabbitAdmin").build());
    log.info("queue declare result:{}", queue_flx);
    log.info("declare a queue by admin end===========");
  }

  @Test
  public void rabbitAdminAddQueueForDeadLetterTest() {
    log.info("declare a queue by admin start===========");
    String queue_zpl = rabbitAdmin
        .declareQueue(QueueBuilder.durable("xboot.queue_hn_zpl.by.rabbitAdmin").build());
    log.info("queue declare result:{}", queue_zpl);
    log.info("declare a queue by admin end===========");
  }

  @Test
  public void rabbitAdminAddDeadLetterQueueTest() {
    log.info("declare a dead letter queue by admin start===========");
    String queue_zpl = rabbitAdmin
        .declareQueue(
            QueueBuilder.durable("xboot.queue_hn_zpl.dead.letter.by.rabbitAdmin").build());
    log.info("queue declare result:{}", queue_zpl);
    log.info("declare a dead letter queue by admin end===========");
  }

  @Test
  public void rabbitAdminAddRedirectQueueTest() {
    log.info("declare a redirect queue by admin start===========");
    String queue_zpl = rabbitAdmin
        .declareQueue(
            QueueBuilder.durable("xboot.queue_hn_zpl.dead.letter.redirect.by.rabbitAdmin").build());
    log.info("queue declare result:{}", queue_zpl);
    log.info("declare a redirect queue by admin end===========");
  }

  @Test
  public void rabbitAdminAddRedirectBindingTest() {
    log.info("declare a dead binding by admin start===========");
    rabbitAdmin.declareBinding(
        BindingBuilder.bind(new Queue("xboot.queue_hn_zpl.dead.letter.redirect.by.rabbitAdmin"))
            .to(new DirectExchange(DEAD_LETTER_EXCHANGE)).with(DEAD_LETTER_QUEUE_ZPL_ROUTING_KEY));
    log.info("declare a dead binding by admin start===========");
  }


  @Test
  public void rabbitAdminAddQueueWithDeadLetterTest() {
    log.info("declare a queue and binding about dead letter by admin start===========");
    Map<String, Object> args = Maps.newHashMapWithExpectedSize(2);
//       x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
    args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
//       x-dead-letter-routing-key  这里声明当前队列的死信路由key
    args.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUE_ZPL_ROUTING_KEY);

    String queue_zpl = rabbitAdmin
        .declareQueue(
            QueueBuilder.durable("xboot.queue_hn_zpl.by.rabbitAdmin").withArguments(args).build());
    log.info("queue declare result:{}", queue_zpl);

    rabbitAdmin.declareBinding(BindingBuilder.bind(
        QueueBuilder.durable("xboot.queue_hn_zpl.by.rabbitAdmin").withArguments(args).build())
        .to(ExchangeBuilder.directExchange("xboot.direct.by.rabbitAdmin").durable(true).build())
        .with("zpl").noargs());

    log.info("declare a queue and binding about dead letter by admin end===========");
  }

  @Test
  public void rabbitAdminAddDeadLetterBindingTest() {
    log.info("declare a dead binding by admin start===========");
    rabbitAdmin.declareBinding(
        BindingBuilder.bind(new Queue("xboot.queue_hn_zpl.dead.letter.by.rabbitAdmin"))
            .to(new DirectExchange(DEAD_LETTER_EXCHANGE)).with(DEAD_LETTER_QUEUE_ZPL_ROUTING_KEY));
    log.info("declare a dead binding by admin start===========");
  }

  @Test
  public void rabbitAdminAddBindingTest() {
    log.info("declare a binding by admin start===========");
    rabbitAdmin.declareBinding(BindingBuilder.bind(new Queue("xboot.queue.by.rabbitAdmin"))
        .to(new FanoutExchange("xboot.fanout.by.rabbitAdmin")));
    rabbitAdmin.declareBinding(BindingBuilder.bind(new Queue("xboot.queue_hn_xkx.by.rabbitAdmin"))
        .to(new DirectExchange("xboot.direct.by.rabbitAdmin")).with("xkx"));
    rabbitAdmin.declareBinding(BindingBuilder.bind(new Queue("xboot.queue_hn_ytt.by.rabbitAdmin"))
        .to(new DirectExchange("xboot.direct.by.rabbitAdmin")).with("ytt"));
    log.info("declare a binding by admin end===========");
  }

  @Test
  public void rabbitAdminAddBindingForDeadLetterTest() {
    log.info("declare a binding by admin start===========");
    rabbitAdmin.declareBinding(BindingBuilder.bind(new Queue("xboot.queue_hn_zpl.by.rabbitAdmin"))
        .to(new DirectExchange(DEAD_LETTER_EXCHANGE)).with("zpl_dead"));
    log.info("declare a binding by admin end===========");
  }

  @Test
  public void rabbitSendingTest() throws JsonProcessingException, InterruptedException {
    log.info("test send msg to broker start===========");
    CountDownLatch countDownLatch = new CountDownLatch(1);

    BallTeam ballTeam = new BallTeam();
    ballTeam.setName("test_zpl_with_time_out");
    ballTeam.setAddress("beijing");
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(ballTeam);
    //String string = objectMapper.writeValueAsString(ballTeam);

    //Message message = MessageBuilder.withBody(new byte[2]).andProperties(new MessageProperties()).build();

    Map properties = Maps.newHashMapWithExpectedSize(1);
    properties.put("uniqueId", "FAEDEB55708D45F6912EE1388DC3D3DB_timeout");
    MessageHeaders headers = new MessageHeaders(properties);
    org.springframework.messaging.Message<String> message = MessageBuilder
        .createMessage(jsonString, headers);
    Channel channel = rabbitTemplate.getConnectionFactory().createConnection().createChannel(false);

    rabbitTemplate.setConfirmCallback(new ConfirmCallback() {
      @Override
      public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(correlationData.toString());
        log.info("{}", ack);
        log.info(cause);
      }
    });
    rabbitTemplate.setReturnCallback(new ReturnCallback() {
      @Override
      public void returnedMessage(Message message, int replyCode, String replyText, String exchange,
          String routingKey) {
        log.info("return call back message: {}", message);
        log.info("return call back replyCode: {}", replyCode);
        log.info("return call back replyText: {}", replyText);
        log.info("return call back exchange: {}", exchange);
        log.info("return call back routingKey: {}", routingKey);
      }
    });

    rabbitTemplate.addBeforePublishPostProcessors(new MessagePostProcessor() {
      @Override
      public Message postProcessMessage(Message message) throws AmqpException {
        log.info("enter before publish post processor");
        message.getMessageProperties().setExpiration("60000");
        return message;
      }
    });
    rabbitTemplate.convertAndSend("xboot.direct.by.rabbitAdmin", "zpl", ballTeam,
        new CorrelationData(MapUtils.getString(properties, "uniqueId")));

    log.info("test send msg to broker end===========");

    countDownLatch.await();
  }

  @Test
  public void rabbitReceivingTest() {
    log.info("test receive msg from broker start===========");
    Message message = this.rabbitTemplate.receive("xboot.queue_hn_xkx.by.rabbitAdmin");
    log.info("the msg from broker is:{}", message);
    String body = new String(message.getBody());
    log.info("the body of the msg is:{}", body);
    log.info("test receive msg from broker end===========");
  }

}
