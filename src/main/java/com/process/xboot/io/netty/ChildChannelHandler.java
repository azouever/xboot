package com.process.xboot.io.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

  private final Logger log = LoggerFactory.getLogger(getClass());


  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ch.pipeline().addLast(new TimeServerHandle());
  }
}
