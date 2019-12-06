package com.process.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xkx
 * @description
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "leaf_bill")
public class Bill {

  /**
   * 账单id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 账单编号
   */
  private String billNo;

  /**
   * 账单金额
   */
  private BigDecimal amount;

  /**
   * 用户
   */
  private Long personId;

  /**
   * 账单备注
   */
  private String remark;

  /**
   * 创建时间
   */
  private Date createDate;


}
