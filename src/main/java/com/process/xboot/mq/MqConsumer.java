//package com.process.xboot.mq;
//
//import com.process.xboot.entity.BallTeam;
//import com.rabbitmq.client.Channel;
//import java.io.IOException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.QueueBinding;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author xukaixuan
// */
//@Component
////@RabbitListener(queues = "xboot.hello")
//public class MqConsumer {
//
//  private final Logger log = LoggerFactory.getLogger(getClass());
//
//  @RabbitListener(bindings = {
//      @QueueBinding(value = @Queue(value = "xboot.pay.task", durable = "true"),
//          exchange = @Exchange(value = "xboot.pay"), key = "xboot.pay.task")})
//  public void process(String hello, Channel channel, Message message) {
//
//    System.out.println("Receiver  : " + hello);
//
//    log.info("Receiver:{}", hello);
//    try {
//      channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  @RabbitListener(bindings = {
//      @QueueBinding(value = @Queue(value = "xboot.queue.by.rabbitAdmin", durable = "true"),
//          exchange = @Exchange(value = "xboot.fanout.by.rabbitAdmin"), key = {"xkx", "ytt"})})
//  public void processMsgByAdmin(String msg, Channel channel, Message message) {
//
//    log.info("msg test rabbitAdmin:{}", msg);
//    try {
//      channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  @RabbitListener(bindings = {
//      @QueueBinding(value = @Queue(value = "xboot.queue_hn_xkx.by.rabbitAdmin", durable = "true"),
//          exchange = @Exchange(value = "xboot.direct.by.rabbitAdmin"), key = {"xkx",
//          "ytt"})}, concurrency = "5-10")
//  public void consumeMsg(BallTeam ballTeam, Channel channel, Message message) {
//
//    log.info("msg:{}", message);
//    log.info("body:{}", ballTeam);
//    try {
//      channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  //@RabbitListener(bindings = {
//  //@QueueBinding(value = @Queue(value = "xboot.queue_hn_zpl.by.rabbitAdmin", durable = "true"),
//  //exchange = @Exchange(value = "xboot.direct.by.rabbitAdmin"), key = {"xkx",
//  //"ytt"})}, concurrency = "1")
//  public void consumeMsgTestDead(BallTeam ballTeam, Channel channel, Message message) {
//
//    log.info("msg:{}", message);
//    log.info("body:{}", ballTeam);
//    try {
//      channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//}
