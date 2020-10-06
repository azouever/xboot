package com.process.xboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author xkx
 */
@SpringBootApplication
@MapperScan(basePackages = "com.process.xboot.mapper")
@EntityScan(basePackages = "com.process.xboot.entity")
@ServletComponentScan
//@FakeLog
public class XbootApplication {

  private final static Logger logger = LoggerFactory.getLogger(XbootApplication.class);

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(XbootApplication.class);
    //application.setBannerMode(Mode.OFF);
    logger.info("{[]}", "xkx");
    ConfigurableApplicationContext applicationContext = application.run(args);
  }

  // global listener async
//  @Bean(name = "applicationEventMulticaster")
  public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
    SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();

    ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    taskExecutor.setThreadNamePrefix("asyncEventExecutor-");
    taskExecutor.setCorePoolSize(4);
    taskExecutor.initialize();
    eventMulticaster.setTaskExecutor(taskExecutor);
    return eventMulticaster;
  }

  @Bean
  public PasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }


}
