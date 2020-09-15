package com.process.xboot.modifiers.base;

import com.process.xboot.modifiers.a.ProtectedTestA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class RunTest {

  private static final Logger log = LoggerFactory.getLogger(RunTest.class);

  public static void main(String[] args) throws Exception {
    ProtectedTestA protectedTestA = new ProtectedTestA();
//    protectedTestA.clone();
    BaseTest baseTest = new BaseTest();
    baseTest.clone();

  }

}
