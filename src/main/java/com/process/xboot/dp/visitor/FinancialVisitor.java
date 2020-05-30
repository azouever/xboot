package com.process.xboot.dp.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class FinancialVisitor implements Visitor {

  private static final Logger log = LoggerFactory.getLogger(FinancialVisitor.class);

  @Override
  public void visit(DevEmployee devEmployee) {
    System.out.println("开发员工的薪水:" + devEmployee.getSalary());
  }

  @Override
  public void visit(PmEmployee pmEmployee) {
    System.out.println("开发员工的薪水:" + pmEmployee.getSalary());
  }
}
