package com.process.boot.atomic;

import com.process.boot.entity.BallTeam;
import java.lang.reflect.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

/**
 * @author xkx
 * @description
 */
public class OffsetTest {

  private static final Logger log = LoggerFactory.getLogger(OffsetTest.class);

  private static final String name = "xukaixuan";

  public static Unsafe reflectGetUnsafe() {
    try {

      Field field = Unsafe.class.getDeclaredField("theUnsafe");
      field.setAccessible(true);
      return (Unsafe) field.get(null);
    } catch (Exception e) {

      return null;
    }
  }

  public static void main(String[] args) throws NoSuchFieldException {
//    AtomicInteger atomicInteger = new AtomicInteger(1);
//    atomicInteger.compareAndSet(2, 2);
//    System.out.println(atomicInteger.get());

    // object memory operate
    /**
     Unsafe unsafe = OffsetTest.reflectGetUnsafe();
     BallTeam laker = new BallTeam("laker", "LA");
     long offset = unsafe.objectFieldOffset(laker.getClass().getDeclaredField("name"));
     System.out.println(offset);
     unsafe.putObject(laker,offset,"kobe");
     System.out.println(laker);
     */

    // array offset operate

    String[] names = {"xkx", "yj", "lyd"};
    Unsafe unsafe = OffsetTest.reflectGetUnsafe();
    int baseOffset = unsafe.arrayBaseOffset(names.getClass());

    System.out.println(baseOffset);

    System.out.println(unsafe.arrayIndexScale(names.getClass()));

    unsafe.putObject(names, 20, "wzb");

//    Arrays.stream(names).forEach(name->{
//      System.out.println(name);
//    });

    // set value
    //  System.out.println(unsafe.getObject(names, 20));

    //

    // About Class

    long staticFieldOffset = unsafe.staticFieldOffset(OffsetTest.class.getDeclaredField("name"));
   // System.out.println(staticFieldOffset);

    try {
      BallTeam ballTeam = (BallTeam) unsafe.allocateInstance(BallTeam.class);
      ballTeam.setName("bull");
      System.out.println(ballTeam);
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
    System.out.println(unsafe.addressSize());
    System.out.println(unsafe.pageSize());
  }

}
