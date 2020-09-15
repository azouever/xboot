package com.process.xboot.modifiers.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class BaseTest {

  private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

}
