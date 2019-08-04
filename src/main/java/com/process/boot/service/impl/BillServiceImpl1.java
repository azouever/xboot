package com.process.boot.service.impl;

import com.process.boot.entity.Bill;
import com.process.boot.exception.XbootRuntimeException;
import com.process.boot.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author xkx
 * @description
 */
@Slf4j
@Service
@EnableAsync
public class BillServiceImpl1 implements BillService {

  public BillServiceImpl1() {
    System.out.println("我被调用了");
    System.out.println("我被调用了");
    System.out.println("我被调用了");
  }

  @Override
  public void findBills() {
    log.info("find all bills now, no parameters");
    throw new XbootRuntimeException("test global exception catch");
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void saveBill(Bill bill) {
    System.out.println(this);
    log.info("当前线程是否处于事务中:{}", TransactionSynchronizationManager.isActualTransactionActive());
    log.info("当前线程的事务隔离级别:{}", TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());
    log.info("当前线程的事务名字:{}", TransactionSynchronizationManager.getCurrentTransactionName());
  }
}
