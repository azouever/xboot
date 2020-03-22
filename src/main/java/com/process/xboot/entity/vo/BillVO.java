package com.process.xboot.entity.vo;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xkx
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillVO {

  /**
   * 账单编号
   */
  private String billNo;

  /**
   * 账单金额
   */
  private BigDecimal amount;

  /**
   * 账单备注
   */
  private String remark;


}
