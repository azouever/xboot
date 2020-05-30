package com.process.xboot.controller;


import com.process.xboot.entity.BallTeam;
import com.process.xboot.entity.Bill;
import com.process.xboot.entity.Plan;
import com.process.xboot.entity.vo.BillVO;
import com.process.xboot.service.BillService;
import com.process.xboot.service.impl.BillServiceImpl1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.TargetClassAware;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;

/**
 * @author xkx
 * @description 账单接口
 */
@Slf4j
@RestController
@RequestMapping("/bill")
public class BillController {

  @Autowired
  private ApplicationContext applicationContext;

  private final BillService billService;

  public BillController(BillServiceImpl1 billService) {
    this.billService = billService;
  }

  @GetMapping("/find")
  public ResponseEntity findBills() {
    billService.findBills();
    log.info("billService的被代理的Class类型:{}", billService.getClass());
    log.info("billService的真实的Class类型:{}", ((TargetClassAware) billService).getTargetClass());
    log.info("billService的真实的Class类型:{}", AopUtils.getTargetClass(billService));

    String[] names = applicationContext.getBeanNamesForType(BillService.class);
    Arrays.stream(names).forEach(System.out::println);
    return ResponseEntity.ok("账单列表");
  }

  @PostMapping("/save")
  public ResponseEntity save(@RequestBody BillVO billVO) {
    Bill bill = new Bill();
    BeanUtils.copyProperties(billVO, bill);
    bill.setCreateDate(new Date());
    bill.setPersonId(23L);
    try {
      billService.saveBill(bill);
    } catch (Exception e) {
      log.warn("save bill occur exception:{}", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("保存账单异常");
    }
    return ResponseEntity.ok("保存成功");
  }

  @GetMapping("/view")
  public ModelAndView findView() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("hello");
    return mv;
  }

  @GetMapping("/json")
  public Plan findJson() {
    Plan plan = Plan.builder().name("plan0").type(1).build();
    return plan;
  }

  @GetMapping("/ballTeam")
  public String ballTeam() {
    BallTeam ballTeam = applicationContext.getBean(BallTeam.class);
    return ballTeam.getName();
  }

  @GetMapping("/")
  public String echo() {
    BallTeam ballTeam = applicationContext.getBean(BallTeam.class);
    return ballTeam.getName();
  }
}

