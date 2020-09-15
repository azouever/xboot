package com.process.xboot.service.impl;

import com.process.xboot.entity.Bill;
import com.process.xboot.exception.XbootRuntimeException;
import com.process.xboot.service.BillService;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
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
@Primary
public class BillServiceImpl implements BillService {

  private static ReentrantLock lock = new ReentrantLock();
  public static Condition condition = lock.newCondition();

  public BillServiceImpl() {
    System.out.println("我被调用了");
    System.out.println("我被调用了");
    System.out.println("我被调用了");
  }

  @Override
  public List findBills() {
    log.info("find all bills now, no parameters");
    throw new XbootRuntimeException("test global exception catch");
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void saveBill(Bill bill) {

    try {
      lock.lock();
      System.out.println(this);
      log.info("当前线程是否处于事务中:{}", TransactionSynchronizationManager.isActualTransactionActive());
      log.info("当前线程的事务隔离级别:{}",
          TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());
      log.info("当前线程的事务名字:{}", TransactionSynchronizationManager.getCurrentTransactionName());
    } finally {
      lock.unlock();
    }

  }
}
