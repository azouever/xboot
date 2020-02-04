package com.process.boot.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xkx
 * @description do something
 */
@RestController
public class MqController {

  private static final Logger log = LoggerFactory.getLogger(MqController.class);

  @Autowired
  private MqSenderService mqSenderService;

  @GetMapping("/send/{data}")
  public ResponseEntity sendMsg(@PathVariable(name = "data") String data) {
    log.info("controller接收到的data===>{}<===", data);
    try {
      mqSenderService.send(data);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      log.error("exception happened when send message to rabbitmq:", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
