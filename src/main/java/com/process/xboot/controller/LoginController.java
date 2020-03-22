package com.process.xboot.controller;


import com.process.xboot.service.SettlementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xkx
 * @description 登录接口
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private SettlementService settlementService;

  @PostMapping("/ok")
  public ResponseEntity check() {
    return ResponseEntity.ok("登录成功");
  }

}
