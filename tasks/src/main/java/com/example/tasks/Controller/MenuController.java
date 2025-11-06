package com.example.tasks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuController {

  @GetMapping("/")
  public String redirectMenu() {
    return "menu";
  }

  @GetMapping("/menu")
  public String getMenu() {
    return "menu";
  }

  @PostMapping("/menu")
  public String postMenu() {
    return "menu";
  }

}
