package com.process.xboot.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description do something
 */
public class Producer {

  private static final Logger log = LoggerFactory.getLogger(Producer.class);

  public static void main(String[] args) throws IOException, TimeoutException {
    //创建连接工厂
    ConnectionFactory factory = new ConnectionFactory();
    factory.setUsername("admin");
    factory.setPassword("123456");
    //设置 RabbitMQ 地址
    factory.setHost("localhost");
    //建立到代理服务器到连接
    Connection conn = factory.newConnection();
    //获得信道
    Channel channel = conn.createChannel();
    //声明交换器
    String exchangeName = "hello-exchange";
    channel.exchangeDeclare(exchangeName, "direct", true);

    String routingKey = "hola";
    //发布消息
    byte[] messageBodyBytes = "quit".getBytes();
    channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

    channel.close();
    conn.close();
  }
}

