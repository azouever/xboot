package com.process.boot.stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class StreamTest {

  private final Logger log = LoggerFactory.getLogger(getClass());


  @Test
  public void peek() {
    Integer[] nums0 = {26500, 34000, 50000, 55500, 49000};
//    Integer[] nums1 = {3000, 99000, 43000, 29000, 16000};
//    Integer[] nums2 = {40500, 45500, 25000, 16000, 99000};
//    Stream.of(nums0, nums1, nums2).flatMap(Stream::of)
//        .forEach(money -> System.out.println("withdraw money :" + money));
    Stream.of(nums0).peek(num -> {
      num = num + 1;
      System.out.println(num);
    }).forEach(System.out::println);

  }

  @Test
  public void anyMatch() {
    Integer[] nums0 = {26500, 34000, 50000, 55500, 49000};
    boolean exist = Stream.of(nums0).anyMatch(num -> num > 35000);
    System.out.println(exist);
  }

  @Test
  public void allMatch() {
    Integer[] nums0 = {26500, 34000, 50000, 55500, 49000};
    boolean exist = Stream.of(nums0).allMatch(num -> num > 25000);
    System.out.println(exist);
  }

  @Test
  public void noneMatch() {
    Integer[] nums0 = {26500, 34000, 50000, 55500, 49000};
    boolean exist = Stream.of(nums0).noneMatch(num -> num > 60000);
    System.out.println(exist);
  }

  @Test
  public void findAny() {
    Integer[] nums0 = {26500, 34000, 50000, 55500, 49000};
    Optional<Integer> any = Stream.of(nums0).findAny();
    System.out.println(any.get());
  }

  @Test
  public void reduce() {
    Integer[] nums0 = {26500, 34000, 50000, 55500, 49000};
    Integer integer = Stream.of(nums0).reduce(0, (a, b) -> a + b);
    log.info(integer.toString());
  }

}
