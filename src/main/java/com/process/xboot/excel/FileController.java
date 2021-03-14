package com.process.xboot.excel;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
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


  @GetMapping(value = "/anotherDown", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public FileSystemResource anotherDown() {
    File file = new File(Thread.currentThread().getContextClassLoader()
        .getResource("template/excel_template.xlsx").getFile());
    return new FileSystemResource(file);
  }

  @GetMapping(value = "/anotherDownByCopyStream", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public void anotherDownByCopyStream(HttpServletResponse response) {

    String templateName = "excel_template.xlsx";
    try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("template/" + templateName);
    ) {
      // copy it to response's OutputStream
      response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
          "attachment;filename=" + URLEncoder.encode(templateName, "utf8"));
      // 指明response的返回对象是文件流
      org.apache.commons.io.IOUtils.copy(inputStream, response.getOutputStream());
      response.flushBuffer();
    } catch (IOException ex) {
      log.info("Error writing file to output stream. Filename was '{}'", templateName, ex);
      throw new RuntimeException("IOError writing file to output stream");
    }

  }
}

