package com.process.xboot.config;

import com.process.xboot.config.condition.RocketsCond;
import com.process.xboot.config.condition.ThunderCond;
import com.process.xboot.entity.BallTeam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @author xkx
 * @description @import 注解测试
 */
//@Import(BallTeam.class)
@Component
public class ImportConfig {

  @Bean("rockets")
  @Conditional(RocketsCond.class)
  public BallTeam createRockets() {
    System.out.println("create rockets team");
    return new BallTeam("rocket", "huston");
  }

  @Bean("thunder")
  @Conditional(ThunderCond.class)
  public BallTeam createThunder() {
    System.out.println("create thunder team");
    return new BallTeam("thunder", "okc");
  }
}
