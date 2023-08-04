package org.spring.security02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
  @GetMapping({"","/index"})
  public String index(){
    return "index";
  }
  @GetMapping("/shop")
  public @ResponseBody String shop(){
    return "shop";
  }
  @GetMapping("/admin")
  public @ResponseBody String admin(){
    return "admin";
  }



}
