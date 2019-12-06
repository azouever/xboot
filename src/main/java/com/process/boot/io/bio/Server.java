package com.process.boot.io.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class Server {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final static ExecutorService executorService = Executors.newFixedThreadPool(20);

  public static void main(String[] args) {
    int port = 10080;

    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(port);
      System.out.println("time server is start in :" + port);
        Socket socket = serverSocket.accept();
        System.out.println("客户端已经连接上服务器啦！");
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
//        executorService.submit(new handleTask(socket));
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (serverSocket != null) {
        try {
          serverSocket.close();
          System.out.println("time server is close");
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }


  static class handleTask implements Runnable {

    private Socket socket;

    public handleTask(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
          BufferedWriter writer = new BufferedWriter(
              new OutputStreamWriter(socket.getOutputStream()));
      ) {
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(reader.readLine());
        stringBuilder.append("time:" + new Date());
        writer.write(stringBuilder.toString());
        writer.flush();
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (socket != null) {
          try {
            socket.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
