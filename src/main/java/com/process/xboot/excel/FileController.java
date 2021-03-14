package com.process.xboot.excel;


import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xkx
 * @description 账单接口
 */
@Slf4j
@RestController
@RequestMapping("/test/file")
public class FileController {

  private static final String REDIRECT_URL = "http://www.google.com";

  @Autowired
  private ApplicationContext applicationContext;


  /**
   * reference https://stackoverflow.com/questions/10615797/utility-of-http-header-content-type-application-force-download-for-mobile
   */
  @GetMapping({"/downloadFileTemplate"})
  public HttpEntity<ByteArrayResource> downloadFileTemplate() throws IOException {

    String templateName = "excel_template.xlsx";

    try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("template/" + templateName);
    ) {
      HttpHeaders header = new HttpHeaders();
      header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//    header.setContentType(new MediaType("application", "force-download"));
      header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=my_file.xlsx");
//      header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; etc etc");

      return new HttpEntity<>(new ByteArrayResource(inputStream.readAllBytes()), header);
    }
  }
}

