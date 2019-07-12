package com.process.boot;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * @author xkx
 * @description
 */
public class StringUtilsTest {

  @Test
  public void test0() {
    String[] names = {"xukaixuan", "yangjie","liyadong"};
    String str = StringUtils.arrayToCommaDelimitedString(names);
    System.out.println(str);
  }
}
