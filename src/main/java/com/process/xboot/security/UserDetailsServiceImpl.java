package com.process.xboot.security;

import static java.util.Collections.emptyList;

import com.process.xboot.entity.ApplicationUser;
import com.process.xboot.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private ApplicationUserRepository applicationUserRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
    this.applicationUserRepository = applicationUserRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
//    if (applicationUser == null) {
//      throw new UsernameNotFoundException(username);
//    }
    ApplicationUser applicationUser = new ApplicationUser("kai", passwordEncoder.encode("123"));
    return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
  }
}