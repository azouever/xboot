package com.process.xboot.tx;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kai
 * @description do something
 */
@RestController
public class TxController {


  private static final Logger log = LoggerFactory.getLogger(TxController.class);

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private MainService mainService;

  @GetMapping("tx")
  public void testTx() {
    mainService.handleCoreData();
  }

  @GetMapping("txManagers")
  public void testTxMangers() {

    Map<String, PlatformTransactionManager> beans = applicationContext
        .getBeansOfType(PlatformTransactionManager.class);
    beans.entrySet().forEach(entry -> {
      System.out.println(entry.getKey() + "-----------" + entry.getValue());
    });
  }
}

