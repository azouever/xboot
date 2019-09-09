package com.process.boot.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name = "leaf_goods")
@Entity
public class Goods {

  /**
   * 商品id
   */
  private Long id;

  /**
   * 商品编号
   */
  private String goodsNo;

  /**
   * 商品价格
   */
  private BigDecimal price;

  /**
   * 商品数量
   */
  private Integer quantity;

  /**
   * 商品状态（上架、下架）
   */
  private Integer status;

  /**
   * 进入系统的时间
   */
  private Date createDate;

}
