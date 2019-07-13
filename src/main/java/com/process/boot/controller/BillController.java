package com.process.boot.controller;


import com.process.boot.entity.Bill;
import com.process.boot.entity.Plan;
import com.process.boot.entity.vo.BillVO;
import com.process.boot.service.BillService;
import java.util.Date;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.TargetClassAware;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xkx
 * @description 账单接口
 */
@Slf4j
@RestController
public class BillController {

  private final BillService billService;

  public BillController(BillService billService) {
    this.billService = billService;
  }

  @GetMapping("/bills")
  public ResponseEntity findBills() {
    //billService.findBills();
    log.info("billService的被代理的Class类型:{}", billService.getClass());
    log.info("billService的真实的Class类型:{}", ((TargetClassAware) billService).getTargetClass());
    log.info("billService的真实的Class类型:{}", AopUtils.getTargetClass(billService));
    return ResponseEntity.ok("账单列表");
  }

  @PostMapping("/bill/save")
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
}
