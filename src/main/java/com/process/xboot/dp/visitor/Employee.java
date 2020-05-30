package com.process.xboot.dp.visitor;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author Kai
 */
@Data
public abstract class Employee {

  private String name;
  private BigDecimal salary;

  /**
   * @param visitor 访问者 业务对象支持哪些访问者
   */
  public abstract void accept(Visitor visitor);


}
