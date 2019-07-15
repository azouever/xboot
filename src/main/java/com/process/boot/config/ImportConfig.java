package com.process.boot.config;

import com.process.boot.config.condition.RocketsCond;
import com.process.boot.config.condition.ThunderCond;
import com.process.boot.entity.BallTeam;
import com.process.boot.entity.Nba;
import com.process.boot.entity.Team;
import com.process.boot.entity.nba.Rockets;
import com.process.boot.entity.nba.Thunder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;
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
