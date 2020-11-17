package com.process.xboot.jdk8.functionprogram.bifunction_demo;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Java8BiFunction2b {

  public static void main(String[] args) {

    String result = powToString(2, 4,
        (a1, a2) -> Math.pow(a1, a2),
        (r) -> "Result : " + String.valueOf(r));

    System.out.println(result); // Result : 16.0

  }

  public static <R> R powToString(Integer a1, Integer a2,
      BiFunction<Integer, Integer, Double> func,
      Function<Double, R> func2) {

    return func.andThen(func2).apply(a1, a2);

  }

}