package com.process.boot.service;

import com.process.boot.entity.Bill;

/**
 * @author xkx
 * @description
 */
public interface BillService {

  /**
   * 查询账单列表
   */
  void findBills();

  /**
   * 查询账单列表
   */
  void saveBill(Bill bill);

}
