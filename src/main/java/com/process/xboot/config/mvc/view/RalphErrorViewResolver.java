package com.process.xboot.config.mvc.view;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RalphErrorViewResolver implements ErrorViewResolver {

  private static final String ROOT = "/static/HTTP";
  private static final List<Integer> CODE_LIST = Lists
      .newArrayList(HttpStatus.NOT_FOUND.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
          HttpStatus.UNAUTHORIZED.value());

  @Override
  public ModelAndView resolveErrorView(HttpServletRequest request,
      HttpStatus status, Map<String, Object> model) {
//    if (status != null && CODE_LIST.contains(status.value())) {
//      return new ModelAndView("redirect:" + ROOT + status);
//    }
    return new ModelAndView("redirect:" + ROOT + status.value() + ".html");
//    return new ModelAndView( "redirect:" + "https://www.google.com");
  }
}