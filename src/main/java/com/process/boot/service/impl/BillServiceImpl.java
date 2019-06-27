package com.process.boot.service.impl;

import com.process.boot.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xkx
 * @description
 */
@Slf4j
@Service
public class BillServiceImpl implements BillService {

  @Override
  public void findBills() {
    log.info("find all bills now, no parameters");
  }
}
