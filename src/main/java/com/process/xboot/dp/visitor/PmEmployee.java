package com.process.xboot.dp.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */
public class PmEmployee extends Employee {

  private static final Logger log = LoggerFactory.getLogger(PmEmployee.class);

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
