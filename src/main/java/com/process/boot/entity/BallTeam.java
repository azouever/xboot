package com.process.boot.entity;

import org.springframework.stereotype.Component;

/**
 * @author xkx
 * @description
 */
//@Component
public class BallTeam implements Team {

  private String name;
  private String address;

  static {
    System.out.println("静态代码块被执行");
  }

  public BallTeam() {
  }

  public BallTeam(String name, String address) {
    System.out.println(this.getClass().getName() + "constructor running ...");
    this.name = name;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
