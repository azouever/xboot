package com.process.xboot.controller;

import com.process.xboot.config.mvc.messageConverter.Report;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kai
 */

@RestController
public class ReportController {


  @GetMapping("/customMessageConverter")
  public Report customMessageConverter() {
    Report report = new Report();
    report.setId(898);
    report.setContent("report_content");
    report.setReportName("report_name");
    return report;
  }
}
