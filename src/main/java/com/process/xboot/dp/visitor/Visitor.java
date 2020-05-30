package com.process.xboot.dp.visitor;

/**
 * @author Kai
 */
public interface Visitor {

  // 不同的访问者实现不同的重载,然后解析出自己想要的数据;

  void visit(DevEmployee devEmployee);

  void visit(PmEmployee pmEmployee);
}
