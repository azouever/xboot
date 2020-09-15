package com.process.xboot.apollo;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai apollo 源码中 看到 多个meta server时，它需要random load balancing ，所以使用了
 * Collections.shuffle(metaServers);
 */
public class ShuffleTest {

  private static final Logger log = LoggerFactory.getLogger(ShuffleTest.class);

  public static void main(String[] args) {
    List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5);

    Collections.shuffle(integers);

    System.out.println(integers);

  }

}
