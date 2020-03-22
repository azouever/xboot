package com.process.xboot;

import com.alibaba.fastjson.JSON;
import com.process.xboot.entity.nba.Rockets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xkx
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SerializationTest {

  @Autowired
  private RedisTemplate redisTemplate;


  public void toDisk() {
    JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
    StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    Rockets rockets = new Rockets("yao", "harden");
    byte[] serialize = jdkSerializationRedisSerializer.serialize(rockets);
    System.out.println(new String(serialize));
    byte[] serialize1 = stringRedisSerializer.serialize(JSON.toJSONString(rockets));
    System.out.println(new String(serialize1));
  }

  @Test
  public void customRedisTemplate() {
    Rockets rockets = new Rockets("yao", "harden");
    redisTemplate.opsForValue().set("rockets", rockets);
    System.out.println(redisTemplate);
  }

}
