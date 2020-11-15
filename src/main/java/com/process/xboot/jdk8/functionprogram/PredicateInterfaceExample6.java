package com.process.xboot.jdk8.functionprogram;
// Java program to illustrate
// negate Predicate 

import cn.hutool.core.lang.Assert;
import java.util.function.Predicate;

class PredicateInterfaceExample6 {

  public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
    @Override
    public boolean test(String t) {
      return t.length() > 10;
    }
  };

  public static void predicate_negate() {

    String lengthGTThan10 = "Thunderstruck is a 2012 children's "
        + "film starring Kevin Durant";

    boolean outcome = hasLengthOf10.negate().test(lengthGTThan10);

    Assert.isFalse(outcome);
    System.out.println(outcome);
  }

  public static void main(String[] args) {
    predicate_negate();
  }
} 
