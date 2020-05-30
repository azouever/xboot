package com.process.xboot.zookeeper.origin;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 * @description do something
 */
public class ConnectDemo implements Watcher {

  private static final Logger log = LoggerFactory.getLogger(ConnectDemo.class);

  private static CountDownLatch countDownLatch = new CountDownLatch(1);

  private static final String IP = "localhost";
  private static final String PORT = "2181";
  private static final String ADDRESS = IP + ":" + PORT;

  public static void main(String[] args) throws IOException {
    ZooKeeper zooKeeper = new ZooKeeper(ADDRESS, 5000, new ConnectDemo());
    log.info(zooKeeper.getState().toString());
    try {
      countDownLatch.await();
      log.info(zooKeeper.getState().toString());
      log.info("zookeeper connection established");
      log.info(zooKeeper.toString());
      //countDownLatch.wait();

      String actualPath = zooKeeper
          .create("/test_cli", new String("by api").getBytes(), Ids.OPEN_ACL_UNSAFE,
              CreateMode.PERSISTENT_SEQUENTIAL);
      System.out.println(actualPath);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void process(WatchedEvent watchedEvent) {
    log.error(watchedEvent.toString());
    countDownLatch.countDown();
  }
}
