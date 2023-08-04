package org.spring.security02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration// 설정(공유)
@EnableWebSecurity
public class WebSecurityConfigClass {

  // 비빌번호 암호화 객체
  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  @Bean
  public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    // POST-> 웹페이지 보안 공격
    http.csrf().disable();

    // 사용자 요청에 대한 페이지별 설정
    http.authorizeHttpRequests()
            // 모든 접근 허용
            .antMatchers("/","/member/login","/member/join").permitAll()
            .antMatchers("/css/**","/images/**","/js/**").permitAll()
            // 로그인시 접근 허용
            .antMatchers("/member/logOut").authenticated()
            // MEMBER, ADMIN
            .antMatchers("/member/memberShip").hasAnyRole("ADMIN","MEMBER")
            // SELLER, ADMIN
            .antMatchers("/shop/**").hasAnyRole("ADMIN","SELLER")
            //  ADMIN
            .antMatchers("/admin/**").hasAnyRole("ADMIN")
            ;
    // 로그인 설정
    http.formLogin()
            .loginPage("/member/login")  // 직접 로그인페이지를 설정, 권한이 없는 페이지 -> 자동 이동
            .usernameParameter("email")   //username -> 아이디
            .passwordParameter("pw")      //password -> 비빌번호
            .loginProcessingUrl("/member/login") // form URL POST
            .defaultSuccessUrl("/")   // 로그인 성공시
            .failureUrl("/member/loginFail")
            .permitAll();

    // 로그아웃 설정  -> logout(기본)
    http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/member/logOut")) // 직접 로그아웃URL
            .logoutSuccessUrl("/")
            ;

    return http.build();
  }





}
