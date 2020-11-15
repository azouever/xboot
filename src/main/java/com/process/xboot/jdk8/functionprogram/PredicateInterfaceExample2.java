package com.process.xboot.jdk8.functionprogram;

import java.util.function.Predicate;

public class PredicateInterfaceExample2 {

  public static void main(String[] args) {
    Predicate<Integer> greaterThanTen = (i) -> i > 10;

    // Creating predicate
    Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
    boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
    System.out.println(result);

    // Calling Predicate method
    boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
    System.out.println(result2);

    // Calling Predicate method
    boolean result3 = greaterThanTen.and(lowerThanTwenty).negate().test(9);
    System.out.println(result3);

    // Calling Predicate method
    boolean result4 = greaterThanTen.and(lowerThanTwenty).negate().test(25);
    System.out.println(result4);
  }
} 