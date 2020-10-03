package com.demo.api.v1;

import com.demo.api.VersionHelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping(value = { VersionHelper.V1 + "home" })
  public String home() {
    return "home";
  }
}
