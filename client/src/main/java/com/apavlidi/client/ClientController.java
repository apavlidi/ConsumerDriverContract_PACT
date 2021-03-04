package com.apavlidi.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

  @GetMapping("/demo")
  public String retrieveUserPreference() {
    return "Hello World";
  }
}
