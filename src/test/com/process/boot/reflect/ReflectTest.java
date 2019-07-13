package com.process.boot.reflect;

import com.process.boot.entity.BallTeam;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.junit.Test;

/**
 * @author xkx
 * @description
 */
public class ReflectTest {

  @Test
  public void constructTest() {
    try {
      Constructor<BallTeam> noParamConstructor = BallTeam.class.getDeclaredConstructor();
      BallTeam ballTeam = new BallTeam("net", "NewYork");
      Field name = BallTeam.class.getDeclaredField("name");
//      System.out.println(noParamConstructor);
//      System.out.println(noParamConstructor.isAccessible());
      System.out.println(name);
      System.out.println(name.isAccessible());
//      name.setAccessible(true);
      System.out.println(name.get(ballTeam));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void propertyTest() {

    PropertyTokenizer propertyTokenizer = new PropertyTokenizer("map.name");
    System.out.println(propertyTokenizer);
  }
}
