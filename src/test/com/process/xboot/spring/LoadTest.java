package com.process.xboot.spring;

import com.process.xboot.entity.Team;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xkx
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoadTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void main() {
    DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext
        .getAutowireCapableBeanFactory();
    String[] names = beanFactory
        .getBeanNamesForType(Team.class);
    Arrays.stream(names).forEach(name -> System.out.println(beanFactory.getType(name)));
  }

}
