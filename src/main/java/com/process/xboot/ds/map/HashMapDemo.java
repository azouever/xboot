package com.process.xboot.ds.map;


import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 * @description do something
 */
public class HashMapDemo {

  private static final Logger log = LoggerFactory.getLogger(HashMapDemo.class);

  public static void main(String[] args) {
    Map personMap = new HashMap<>();

    personMap.put("name", "xukaixuan");

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
