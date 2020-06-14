package com.process.xboot.io.nio;

import io.netty.buffer.ByteBufAllocator;
import java.nio.ByteBuffer;
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
  public void byteBufferTest001() {

    ByteBufAllocator bufAllocator = ByteBufAllocator.DEFAULT;

    ByteBuffer allocate = ByteBuffer.allocate(1024);

    System.out.println("limit:" + allocate.limit());

    System.out.println("position:" + allocate.position());

    System.out.println("capacity:" + allocate.capacity());

    allocate.put("xkx".getBytes());

    System.out.println("limit:" + allocate.limit());

    System.out.println("position:" + allocate.position());

    System.out.println("capacity:" + allocate.capacity());
    System.out.println("remain before flip:" + allocate.remaining());
    allocate.flip();

    System.out.println("limit:" + allocate.limit());

    System.out.println("position:" + allocate.position());

    System.out.println("capacity:" + allocate.capacity());

    System.out.println("remain: after flip: " + allocate.remaining());
    allocate.put("kai".getBytes());
    System.out.println("limit:" + allocate.limit());

    System.out.println("position:" + allocate.position());

    System.out.println("capacity:" + allocate.capacity());

    allocate.flip();

    byte[] bytes = new byte[3];
    allocate.get(bytes);
    System.out.println(new String(bytes));

    System.out.println("limit:" + allocate.limit());

    System.out.println("position:" + allocate.position());

    System.out.println("capacity:" + allocate.capacity());


  }
}
