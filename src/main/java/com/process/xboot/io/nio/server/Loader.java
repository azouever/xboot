package com.process.xboot.io.nio.server;

public class Loader {

  public static void main(String[] args) {
    Deamon deamon = new Deamon(9999);
    new Thread(deamon).start();
  }

}