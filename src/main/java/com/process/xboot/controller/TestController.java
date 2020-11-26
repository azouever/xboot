package com.process.xboot.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.process.xboot.entity.BallTeam;
import com.process.xboot.entity.Plan;
import com.process.xboot.service.BillService;
import java.util.Enumeration;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.TargetClassAware;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
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

//  @Autowired

  @Inject
//  @Resource
  @Named("billServiceImpl1")
  private BillService billServiceImpl;

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

  @GetMapping("/403")
  public ModelAndView testViewSuffix(HttpServletRequest request) {
    return new ModelAndView("HTTP403");
  }

  @GetMapping("/json")
  public ResponseEntity<Object> testJson(HttpServletRequest request) {
    BallTeam ballTeam = new BallTeam();
    ballTeam.setName("binpu");
    ballTeam.setAddress("pujiang");
    return ResponseEntity.ok(ballTeam);
  }

  @GetMapping("/asyncServlet")
  public DeferredResult<String> testAsyncServlet(HttpServletRequest request) {
    DeferredResult<String> result = new DeferredResult<>();

    // 使用异步servlet之后，对于客户端来说还是一样的阻塞时长，但是对于服务端来说， 会提高服务端的并发处理能力
    Thread thread = new Thread(() -> {

      try {
        //与客户端建立长连接之后 5秒之后返回结果
        Thread.sleep(5000);

        result.setResult("hello world");
      } catch (Exception e) {

      }
    });
    thread.start();
    return result;
  }

  @GetMapping("/primary")
  public ResponseEntity<Object> testPrimary(
      @CookieValue(value = "sessionToken", required = false) String sessionToken,
      HttpServletRequest request) {
    log.info("测试从cookie中拿值，SessionToken：{}", sessionToken);
    log.info("billService的被代理的Class类型:{}", billServiceImpl.getClass());
    log.info("billService的真实的Class类型:{}", ((TargetClassAware) billServiceImpl).getTargetClass());
    log.info("billService的真实的Class类型:{}", AopUtils.getTargetClass(billServiceImpl));
    return ResponseEntity.ok("primary ok");
  }

  @PostMapping(value = "/form")
  public ResponseEntity<Object> testForm(@RequestBody Plan plan,
      HttpServletRequest httpServletRequest, @RequestParam(required = false) String address) {
    log.info("ok,run in {}", StrUtil.isBlank(address) ? "default" : address);
    log.info(plan.toString());
    Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      System.out.println("request header -->" + headerName + "<--,value: " + httpServletRequest
          .getHeader(headerName));
    }
    return ResponseEntity.ok(JSONUtil.toJsonStr(plan));
  }
}

