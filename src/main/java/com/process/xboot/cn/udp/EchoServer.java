package com.process.xboot.cn.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoServer {


  private static boolean running;
  private static byte[] buf = new byte[256];

  public static void main(String[] args) throws IOException {

    DatagramSocket socket = new DatagramSocket(59090);
    running = true;
    while (running) {
      DatagramPacket packet
          = new DatagramPacket(buf, buf.length);
      socket.receive(packet);
      InetAddress address = packet.getAddress();
      int port = packet.getPort();
      packet = new DatagramPacket(buf, buf.length, address, port);
      String received
          = new String(packet.getData(), 0, packet.getLength());

      if (received.equals("end")) {
        running = false;
        continue;
      }
      socket.send(packet);
    }
    socket.close();
  }
}