package com.process.xboot.controller;


import com.process.xboot.entity.BallTeam;
import com.process.xboot.entity.Plan;
import com.process.xboot.service.SettlementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xkx
 * @description 结算接口
 */
@Slf4j
@RestController
@RequestMapping("/settle")
public class SettlementController {

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private SettlementService settlementService;

  @GetMapping("/find")
  public ResponseEntity findBills() {
    return ResponseEntity.ok("结算单列表");
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
}
