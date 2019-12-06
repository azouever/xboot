package com.process.boot.config.security.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author xkx
 * @description 登录方式自定义：账号密码登录，短信登录，邮箱登录，微信登录等等各种实现
 */

public class XbootAuthenticationProvider implements AuthenticationProvider {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    log.info("Authentication:{}",authentication);
    return authentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {

    return false;
  }
}
