package com.process.xboot.jdk8.functionprogram;

import java.util.function.Predicate;

class PredicateInterfaceExample4 {

  public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
    @Override
    public boolean test(String t) {
      return t.length() > 10;
    }
  };

  public static void predicate_or() {

    Predicate<String> containsLetterA = p -> p.contains("A");
    String containsA = "Bnd";
    boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA);
    System.out.println(outcome);
  }

  public static void main(String[] args) {
    predicate_or();
  }
} 