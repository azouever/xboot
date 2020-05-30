package com.process.xboot.ds.map;



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

}
