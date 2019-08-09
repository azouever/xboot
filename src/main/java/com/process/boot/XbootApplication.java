package com.process.boot;

import com.process.boot.entity.BallTeam;
import java.util.Map;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xkx
 */
@SpringBootApplication
public class XbootApplication {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(XbootApplication.class);
    application.setBannerMode(Mode.OFF);
    ConfigurableApplicationContext applicationContext = application.run(args);
  }

}
