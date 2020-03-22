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

}
