package com.process.xboot.modifiers.a;

import cn.hutool.bloomfilter.BloomFilterUtil;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class ProtectedTestA extends Base2Test {

  private static final Logger log = LoggerFactory.getLogger(ProtectedTestA.class);

  public static void main(String[] args) throws Exception {
    ProtectedTestA.outMsg("test T K V E P C");
    ProtectedTestA protectedTestA = new ProtectedTestA();
    protectedTestA.clone();
    Base2Test base2Test = new Base2Test();
    base2Test.clone();
  }


  public <K, V> void f(K k, V v) {
    System.out.println(k.getClass().getName());
    System.out.println(v.getClass().getName());
  }

  public static void outMsg(String msg) {
    System.out.println(msg);
    ProtectedTestA protectedTestA = new ProtectedTestA();
    protectedTestA.f(BigDecimal.TEN, new BloomFilterUtil());
  }

}
