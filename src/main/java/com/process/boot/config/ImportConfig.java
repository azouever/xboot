package com.process.boot.config;

import com.process.boot.entity.BallTeam;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author xkx
 * @description @import 注解测试
 */
@Import(BallTeam.class)
@Component
public class ImportConfig {

}
