package com.process.xboot.ds.map;


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

}
