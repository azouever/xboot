package com.process.xboot.bytecode;

public class IntegerSupplier extends BaseSupplier {


  /**
   * @return 100
   */
  // 修改返回类型，会生成桥接方法
  @Override
  public Integer get() {
    return 100;
  }
}