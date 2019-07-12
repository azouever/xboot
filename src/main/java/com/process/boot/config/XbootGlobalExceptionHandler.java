package com.process.boot.config;

import com.process.boot.exception.XbootRuntimeException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xkx
 * @description 全局异常统一处理
 */
@ControllerAdvice
public class XbootGlobalExceptionHandler {


  @ExceptionHandler(XbootRuntimeException.class)
  public ModelAndView ralphRuntimeExceptionHandler(HttpServletRequest request,
      XbootRuntimeException exception) throws Exception {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("error");// 异常信息展示到哪个页面，此处指定在error.html页面中进行展示
    return mav;
  }

//  @ExceptionHandler(NullOrEmptyException.class)
//  @ResponseBody
//  public ErrorMessage<String> nullOrEmptyExceptionHandler(HttpServletRequest request,
//    NullOrEmptyException exception) throws Exception {
//    return handleErrorInfo(request, exception.getMessage(), exception);
//  }
//
//  @ExceptionHandler(Exception.class)
//  @ResponseBody
//  public ErrorMessage<String> exceptionHandler(HttpServletRequest request, Exception exception)
//    throws Exception {
//    return handleErrorInfo(request, exception.getMessage(), exception);
//  }
//
//  private ErrorMessage<String> handleErrorInfo(HttpServletRequest request, String message,
//    Exception exception) {
//    ErrorMessage<String> errorMessage = new ErrorMessage<>();
//    errorMessage.setMessage(message);
//    errorMessage.setCode(ErrorMessage.ERROR);
//    errorMessage.setData(message);
//    errorMessage.setUrl(request.getRequestURL().toString());
//    return errorMessage;
//  }

}
