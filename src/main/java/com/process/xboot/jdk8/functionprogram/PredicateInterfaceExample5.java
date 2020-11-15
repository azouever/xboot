package com.process.xboot.jdk8.functionprogram;
// Java program to illustrate AND Predicate

import cn.hutool.core.lang.Assert;
import java.util.function.Predicate;
import java.util.Objects;

class PredicateInterfaceExample5 {

  public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
    @Override
    public boolean test(String t) {
      return t.length() > 10;
    }
  };

  public static void predicate_and() {
    Predicate<String> nonNullPredicate = Objects::nonNull;

    String nullString = null;

    boolean outcome = nonNullPredicate.and(hasLengthOf10).test(nullString);

    Assert.isFalse(outcome);

    String lengthGTThan10 = "Welcome to the machine";
    boolean outcome2 = nonNullPredicate.and(hasLengthOf10).
        test(lengthGTThan10);
    Assert.isTrue(outcome2);
  }

  public static void main(String[] args) {
    predicate_and();
  }
} 
