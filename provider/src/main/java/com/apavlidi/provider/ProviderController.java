package com.apavlidi.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

  @GetMapping("/provide")
  public String retrieveUserPreference() {
    return "Providing services";
  }
}
