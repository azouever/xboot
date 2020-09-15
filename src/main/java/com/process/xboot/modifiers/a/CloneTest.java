package com.process.xboot.modifiers.a;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class CloneTest {

  private static final Logger log = LoggerFactory.getLogger(CloneTest.class);

  public static void main(String[] args) throws Exception {
    Base2Test base2Test = new Base2Test();
    base2Test.clone();
  }
}
