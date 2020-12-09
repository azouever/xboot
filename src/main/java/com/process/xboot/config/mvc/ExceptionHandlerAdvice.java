package com.process.xboot.config.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {


  @ExceptionHandler({NullPointerException.class, ArithmeticException.class})
  @ResponseStatus(value = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED, reason = "hello123")
  @ResponseBody
  public String handlerNullPointer(RuntimeException ex) {
    log.error("error happened:", ex);
    return this.getClass().getSimpleName() + ":" + ex.getMessage();
  }
}