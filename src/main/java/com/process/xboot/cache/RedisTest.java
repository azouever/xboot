package com.process.xboot.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author xkx
 * @description do something
 */
public class RedisTest {

  private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

  @Autowired
  private RedisTemplate redisTemplate;

  public void pipeTest(String[] args) {

  }

}
