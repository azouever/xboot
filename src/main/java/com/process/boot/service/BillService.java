package com.process.boot.service;

import com.process.boot.entity.Bill;

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
