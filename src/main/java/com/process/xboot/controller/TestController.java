package com.process.xboot.controller;


import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author xkx
 * @description 账单接口
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

  private static final String REDIRECT_URL = "http://www.google.com";

  @Autowired
  private ApplicationContext applicationContext;

  @GetMapping("/redirect/by_redirect_view")
  public RedirectView redirect(HttpServletRequest httpServletRequest,
      RedirectAttributes attributes) {
    attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectViewFlash");
    attributes.addAttribute("attribute", "redirectWithRedirectView");
    httpServletRequest.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
//    return new RedirectView(TestController.REDIRECT_URL);
    return new RedirectView("/test/redirect/test_flash_attribute");
  }


  @GetMapping("/redirect/test_flash_attribute")
  public ResponseEntity<Object> flashAttribute(
      @ModelAttribute(name = "flashAttribute", binding = false) String flashAttribute) {
    return ResponseEntity.ok(flashAttribute);
//    return ResponseEntity.ok("hello");
  }


  @PostMapping("/redirectPostToGet")
  public ModelAndView redirectPostToPost(HttpServletRequest request) {
    request.setAttribute(
        View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.MOVED_PERMANENTLY);
    return new ModelAndView("redirect:/test/redirect/test_flash_attribute");
  }

}

