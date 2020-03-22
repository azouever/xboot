package com.process.xboot.entity;

import java.io.Serializable;

/**
 * @author xkx
 * @description
 */
//@Component
public class BallTeam implements Serializable {

  private static final long serialVersionUID = 3645805493216923966L;
  private String name;
  private String address;

  static {
    System.out.println("静态代码块被执行");
  }

  public BallTeam() {
  }

  public BallTeam(String name, String address) {
    //System.out.println(this.getClass().getName() + "constructor running ...");
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
  @Override
  public String toString() {
    return "BallTeam{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
