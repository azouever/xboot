package com.process.xboot.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class ByteBufferTest {

  private final Logger log = LoggerFactory.getLogger(getClass());

  public static void main(String[] args) {

  }



  @Test
  public void byteBufferTest001(){

    ByteBufAllocator bufAllocator = ByteBufAllocator.DEFAULT;

    ByteBuf buffer = bufAllocator.buffer();
    log.error("capacity:"+buffer.capacity());
    log.error("max capacity:"+buffer.maxCapacity());
    buffer.writeBytes("hello".getBytes());
    log.error("read index:"+buffer.readerIndex());
    log.error("write index:"+buffer.writerIndex());

  }
}
