package com.process.boot;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XbootApplicationTests {

  @Test
  public void contextLoads() {
    List<ApplicationContextInitializer> contextInitializers = SpringFactoriesLoader
        .loadFactories(ApplicationContextInitializer.class, ClassUtils.getDefaultClassLoader());
    contextInitializers.forEach(System.out::println);
  }

}
