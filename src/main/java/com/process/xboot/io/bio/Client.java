package com.process.xboot.io.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class Client {

  private final Logger log = LoggerFactory.getLogger(getClass());

  public static void main(String[] args) {

    try (Socket socket = new Socket("127.0.0.1", 10080);
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream()));
    ) {
      writer.write("get time");
      writer.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
