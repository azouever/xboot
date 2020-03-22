package com.process.xboot.ds.map;


import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 * @description do something
 */
public class ConcurrentHashMapDemo {

  private static final Logger log = LoggerFactory.getLogger(ConcurrentHashMapDemo.class);

  public static void main(String[] args) {
    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(30);

    concurrentHashMap.put("name", "xukaixuan");


  }


  static final int tableSizeFor(int cap) {
    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
  }

}
