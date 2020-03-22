package com.process.xboot.mq;

import com.alibaba.fastjson.JSON;
import com.process.xboot.entity.BallTeam;
import com.rabbitmq.client.LongString;
import com.rabbitmq.client.impl.LongStringHelper;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SerializationUtils;
import org.springframework.util.StopWatch;

/**
 * @author Kai
 * @description do something
 */
public class NoSpringTest {

  private static final Logger log = LoggerFactory.getLogger(NoSpringTest.class);


  @Test
  public void LongStringFromRabbitClientTest() {
    LongString longString = LongStringHelper.asLongString("RabbitMQ");
  }

  @Test
  public void serializationTest() throws UnsupportedEncodingException {
    BallTeam ballTeam = new BallTeam();
    ballTeam.setName("test_rabbit");
    ballTeam.setAddress("shanghai");
    String jsonString = JSON.toJSONString(ballTeam);
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    byte[] bytes = jsonString.getBytes("UTF-8");
    System.out.println("fastJson 序列化 bytes[] 长度:" + bytes.length);
    stopWatch.stop();
    System.out.println("fastJson 序列化 bytes[] 时间:" + stopWatch.getLastTaskTimeMillis());
    System.out.println("============ze===============");
    stopWatch.start();
    byte[] bytes1 = SerializationUtils.serialize(ballTeam);
    System.out.println("jdk 序列化 bytes[] 长度:" + bytes1.length);
    stopWatch.stop();
    System.out.println("jdk 序列化 bytes[] 时间:" + stopWatch.getLastTaskTimeMillis());
  }
}
