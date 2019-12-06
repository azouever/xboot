package com.process.boot.io.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * @author xkx
 * @description
 */
public class ServerChannel {

  private final Logger log = LoggerFactory.getLogger(getClass());

  public static void main(String[] args) throws IOException {
    ServerSocketChannel channel = ServerSocketChannel.open();
    channel.socket().bind(new InetSocketAddress(InetAddress.getLocalHost(),10023));
    channel.configureBlocking(false);

    // 创建selector
    Selector selector = Selector.open();

    selector.select(1000);

    Set<SelectionKey> selectionKeys = selector.selectedKeys();

    SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_ACCEPT);
  }


}