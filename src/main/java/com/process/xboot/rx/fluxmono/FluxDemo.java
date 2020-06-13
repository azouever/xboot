package com.process.xboot.rx.fluxmono;

import cn.hutool.core.thread.ThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author Kai
 */
public class FluxDemo {

  private static final Logger log = LoggerFactory.getLogger(FluxDemo.class);

  public static void main(String[] args) {

    Flux<String> flux = Flux.just("tom", "jack", "allen")
        .filter(s -> s.length() > 3)
        .publishOn(Schedulers.elastic())
        .map(s -> s.concat("------" + Thread.currentThread().getName()));
    ThreadUtil.sleep(2000);
    flux.subscribe(s -> {
      System.out.println(s);
    });
  }
}
