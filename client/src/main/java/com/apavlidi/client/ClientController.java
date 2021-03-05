package com.apavlidi.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

  @GetMapping("/sanitize")
  public String sanitizePost() {
    return new RestTemplate().getForObject("http://localhost:8080/post/1", String.class);
  }
}
