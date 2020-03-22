package com.process.xboot.mq;

/**
 * @author xkx
 * @description do something
 */
public interface MqSenderService {

  /**
   * 消息发送服务
   * @param msg 消息
   */
  void send(String msg);

}
