package com.process.xboot.serviceloader.impl;

import com.google.auto.service.AutoService;
import com.process.xboot.serviceloader.Say;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
@AutoService(Say.class)
public class SayImpl implements Say {

  private static final Logger log = LoggerFactory.getLogger(SayImpl.class);

  @Override
  public void say() {
    log.info("test google auto service");
  }
}
