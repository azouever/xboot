package com.process.xboot.tx.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import com.process.xboot.entity.Bill;
import com.process.xboot.mapper.BillMapper;
import com.process.xboot.tx.MainService;
import com.process.xboot.tx.SecondService;
import java.math.BigDecimal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author Kai
 * @description do something
 */
@Service("mainService")
@Primary
public class MainServiceImpl implements MainService {

  private static final Logger log = LoggerFactory.getLogger(MainServiceImpl.class);

  @Autowired
  private BillMapper billMapper;

  @Autowired
  private SecondService secondService;

  @Autowired
  private PlatformTransactionManager transactionManager;

  @Transactional
  @Override
  public void handleCoreData() {

    Bill bill = Bill.builder().billNo(UUID.fastUUID().toString()).amount(BigDecimal.ONE)
        .createDate(DateUtil.date()).updateDate(DateUtil.date()).personId(35L).build();
    billMapper.insertSelective(bill);
    try {
      secondService.handleNotImportantData();
    } catch (Exception e) {
      log.error("secondService handle exception");
      List<TransactionSynchronization> synchronizations = TransactionSynchronizationManager
          .getSynchronizations();
      System.out.println(synchronizations.get(0));
    }
  }


}
