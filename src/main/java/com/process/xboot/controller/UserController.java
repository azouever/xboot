package com.process.xboot.controller;

import com.process.xboot.entity.ApplicationUser;
import com.process.xboot.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private ApplicationUserRepository applicationUserRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserController(ApplicationUserRepository applicationUserRepository) {
    this.applicationUserRepository = applicationUserRepository;
  }

  @PostMapping("/sign-up")
  public void signUp(@RequestBody ApplicationUser user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
//    applicationUserRepository.save(user);
  }
}