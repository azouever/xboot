package com.process.xboot.dp.visitor;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 */

public class DevEmployee extends Employee {

  private static final Logger log = LoggerFactory.getLogger(DevEmployee.class);

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
