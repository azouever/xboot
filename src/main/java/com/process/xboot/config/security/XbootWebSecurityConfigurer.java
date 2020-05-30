package com.process.xboot.config.security;

import com.process.xboot.config.security.provider.XbootAuthenticationProvider;
import java.time.Duration;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author xkx
 * @description
 */
@Slf4j
@Configuration
public class XbootWebSecurityConfigurer
    extends WebSecurityConfigurerAdapter {

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    super.configure(http);
//    http.authorizeRequests()
//        .antMatchers("/bill/**").hasRole("Role_Bill")
//        .antMatchers("/settle/**").hasRole("Role_Settle")
//        .and()
//        .formLogin().loginPage("login.html")
//        .successHandler(new AuthenticationSuccessHandler() {
//          @Override
//          public void onAuthenticationSuccess(HttpServletRequest request,
//              HttpServletResponse response, Authentication authentication)
//              throws IOException, ServletException {
//            response.sendRedirect("/bill/find");
//          }
//        })
//        .permitAll()
//        .and()
//        .authenticationProvider(xbootAuthenticationProvider());
//  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http
//        .authorizeRequests()
//        .anyRequest().authenticated()
//        .and()
//        .formLogin().and()
//        .httpBasic();
    // handle CSRF attempts
    http.authorizeRequests()
        .antMatchers("/**", "/bill/**", "/test/**", "/resources/**").permitAll()
        .antMatchers("/settle/**").hasRole("settle")
//        .anyRequest().authenticated()
        .and()
//        .formLogin().loginPage("login.html")
//        .permitAll()
//        .and()
        .authenticationProvider(xbootAuthenticationProvider());
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
        .ignoring()
        .antMatchers("/**");
  }


  @Bean
  public AuthenticationProvider xbootAuthenticationProvider() {
    return new XbootAuthenticationProvider();
  }


  //  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("*"));
    configuration.setMaxAge(Duration.ofDays(1).toMillis());
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

}
