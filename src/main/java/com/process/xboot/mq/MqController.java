package com.process.xboot.mq;

import com.google.common.collect.Maps;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xkx
 * @description do something
 */
@RestController
public class MqController {

  private static final Logger log = LoggerFactory.getLogger(MqController.class);

  public static final String DEAD_LETTER_EXCHANGE = "xboot.dead.letter.direct.by.rabbitAdmin";
  public static final String DEAD_LETTER_QUEUE_ZPL_ROUTING_KEY = "dead.letter.queue.zpl.routingkey";

  @Autowired
  private MqSenderService mqSenderService;

  //@Autowired
  private RabbitAdmin rabbitAdmin;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @GetMapping("/send/{data}")
  public ResponseEntity sendMsg(@PathVariable(name = "data") String data) {
    log.info("controller接收到的data===>{}<===", data);
    try {
      mqSenderService.send(data);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      log.error("exception happened when send message to rabbitmq:", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/rabbit")
  public ResponseEntity declareRabbitInfo() {
    try {

      rabbitAdminAddQueueWithDeadLetterTest();
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      log.error("exception happened when send message to rabbitmq:", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

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
}
