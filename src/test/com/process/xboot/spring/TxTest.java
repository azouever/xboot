package com.process.xboot.spring;

import com.process.xboot.entity.Bill;
import com.process.xboot.service.BillService;
import java.math.BigDecimal;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xkx
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TxTest {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  @Qualifier("billServiceImpl1")
  private BillService billService;


  @Test
  public void handleBill() {
    Bill bill = new Bill();
    bill.setBillNo(UUID.randomUUID().toString());
    bill.setAmount(BigDecimal.ONE);
    bill.setRemark("这是一条测试账单");
    billService.saveBill(bill);
  }
}
