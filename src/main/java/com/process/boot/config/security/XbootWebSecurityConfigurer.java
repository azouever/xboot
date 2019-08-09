package com.process.boot.config.security;

import com.process.boot.config.security.provider.XbootAuthenticationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author xkx
 * @description
 */
//@Slf4j
//@Configuration
public class XbootWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    http.authorizeRequests()
        .antMatchers("/bill/**").hasRole("Role_Bill")
        .antMatchers("/settle/**").hasRole("Role_Settle")
        .and()
        .formLogin().loginPage("login.html")
        .permitAll()
        .and()
        .authenticationProvider(xbootAuthenticationProvider());
  }

  @Bean
  public AuthenticationProvider xbootAuthenticationProvider(){
    return new XbootAuthenticationProvider();
  }
}
