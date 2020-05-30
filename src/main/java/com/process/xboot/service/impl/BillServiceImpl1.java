package com.process.xboot.service.impl;

import com.process.xboot.entity.Bill;
import com.process.xboot.entity.Goods;
import com.process.xboot.mapper.BillMapper;
import com.process.xboot.mapper.GoodsMapper;
import com.process.xboot.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author xkx
 * @description
 */
@Slf4j
@Service("billService1")
@EnableAsync
public class BillServiceImpl1 implements BillService {

  @Autowired
  private BillMapper billMapper;

  @Autowired
  private GoodsMapper goodsMapper;

  public BillServiceImpl1() {
    System.out.println("我被调用了");
    System.out.println("我被调用了");
    System.out.println("我被调用了");
  }

  @Override
  public List findBills() {
    //log.info("find all bills now, no parameters");
    //throw new XbootRuntimeException("test global exception catch");
    return this.billMapper.findBills();
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void saveBill(Bill bill) {
    this.billMapper.insertSelective(bill);
    log.info("当前线程是否处于事务中:{}", TransactionSynchronizationManager.isActualTransactionActive());
    log.info("当前线程的事务隔离级别:{}",
        TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());
    log.info("当前线程的事务名字:{}", TransactionSynchronizationManager.getCurrentTransactionName());
    this.updateGoods();
  }

  private void updateGoods() {

    log.info("当前线程是否处于事务中:{}", TransactionSynchronizationManager.isActualTransactionActive());
    log.info("当前线程的事务隔离级别:{}",
        TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());
    log.info("当前线程的事务名字:{}", TransactionSynchronizationManager.getCurrentTransactionName());
    Goods goods = new Goods();
    goods.setGoodsNo(UUID.randomUUID().toString());
    goods.setPrice(BigDecimal.TEN);
    // 表示上架
    goods.setStatus(1);
    goods.setCreateDate(new Date());
    goods.setQuantity(999);
    this.goodsMapper.insert(goods);
    //throw new NullPointerException();
  }
}
