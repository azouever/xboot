package com.process.boot.controller;


import com.process.boot.service.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xkx
 * @description 账单接口
 */
@RestController
public class BillController {

  private final BillService billService;

  public BillController(BillService billService) {
    this.billService = billService;
  }

  @GetMapping("/bills")
  public ResponseEntity findBills() {
    billService.findBills();
    return ResponseEntity.ok("账单列表");
  }
}
