package com.process.xboot.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */

public class CuratorDemo {

  private final Logger log = LoggerFactory.getLogger(getClass());



  public void getZkClient(){
    ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 0);
    CuratorFramework client = CuratorFrameworkFactory
        .newClient("127.0.0.1:2181", retryPolicy);

  }


}
