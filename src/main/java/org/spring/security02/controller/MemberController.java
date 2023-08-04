package org.spring.security02.controller;

import lombok.RequiredArgsConstructor;
import org.spring.security02.dto.MemberDto;
import org.spring.security02.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/login")
  public String login(){
    return "member/login";
  }

  @GetMapping("/loginFail")
  public @ResponseBody String loginFail(){
    return "loginFail";
  }

  @GetMapping("/join")
  public String join(MemberDto memberDto){
    return "member/join";
  }

  @PostMapping("/join")
  public String joinPost(@Valid MemberDto memberDto ,
                         BindingResult bindingResult){
    if(bindingResult.hasErrors()){
      return "member/join";
    }

    memberService.memberInsert(memberDto);
    return "member/login";
  }

  @GetMapping("/memberShip")
  public @ResponseBody String memberShip(){
    return "memberShip 페이지, MEMBER ";
  }


}
