package org.spring.security02.config;

import lombok.AllArgsConstructor;
import org.spring.security02.entity.MemberEntity;
import org.spring.security02.repository.MemberRopository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  // DB 테이블에 사용자정보 == 입력받은(form)정보를 비교 -> 일치 하면 ->User,UserDetails
  private final MemberRopository memberRopository;
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    MemberEntity memberEntity= memberRopository.findByEmail(email).orElseThrow(()->{
      throw new UsernameNotFoundException("이메일 존재하지 않습니다");
    });

    return User.builder()
            .username(memberEntity.getEmail())
            .password(memberEntity.getPw())
            .roles(memberEntity.getRole().toString())
            .build();
  }




}
