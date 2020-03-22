package com.process.xboot.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xukaixuan
 */
@Service
public class MqSenderServiceImpl implements MqSenderService {

  @Autowired
  private AmqpTemplate rabbitTemplate;

  @Override
  public void send(String msg) {
		this.rabbitTemplate.convertAndSend("xboot.pay.status", msg);
	}
}

