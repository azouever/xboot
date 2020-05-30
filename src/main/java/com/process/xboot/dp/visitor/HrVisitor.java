package com.process.xboot.dp.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class HrVisitor implements Visitor {

  private static final Logger log = LoggerFactory.getLogger(HrVisitor.class);

  @Override
  public void visit(DevEmployee devEmployee) {
    System.out.println("开发员工的名字:" + devEmployee.getName());
  }

  @Override
  public void visit(PmEmployee pmEmployee) {
    System.out.println("产品员工的名字:" + pmEmployee.getName());
  }
}
