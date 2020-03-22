package com.process.xboot.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class Server {

  private final Logger log = LoggerFactory.getLogger(getClass());


  public void bind(int port) throws InterruptedException {
    NioEventLoopGroup bossGroup = new NioEventLoopGroup();
    NioEventLoopGroup workerGroup = new NioEventLoopGroup();

    ServerBootstrap s = null;

    s = new ServerBootstrap();
    s.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
        .option(ChannelOption.SO_BACKLOG,1024)
        .childHandler(new ChildChannelHandler());
    ChannelFuture future = s.bind(10088).sync();
    future.channel().closeFuture().sync();
  }
}
