package com.process.xboot.jdk8.functionprogram;

import java.util.function.Predicate;

public class PredicateInterfaceExample1 {

  public static void main(String[] args) {
    // Creating predicate
    Predicate<Integer> lesserThan = i -> (i < 18);

    // Calling Predicate method
    System.out.println(lesserThan.test(10));
  }
} 