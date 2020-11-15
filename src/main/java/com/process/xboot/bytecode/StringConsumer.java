package com.process.xboot.bytecode;

import java.util.function.Consumer;

public class StringConsumer implements Consumer<String> {

  @Override
  public void accept(String s) {
    System.out.println("i consumed " + s);
  }
}