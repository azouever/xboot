package com.process.xboot.service;

import com.process.xboot.entity.Bill;

import java.util.List;

/**
 * @author xkx
 * @description
 */
public interface BillService {

  /**
   * 查询账单列表
   */
  List findBills();

  /**
   * 查询账单列表
   */
  void saveBill(Bill bill);

  /**
   * 账单支付
   *
   * @param billNo 账单编号
   * @return 支付结果
   */
  String pay(String billNo);
}
