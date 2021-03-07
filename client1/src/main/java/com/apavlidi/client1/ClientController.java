package com.apavlidi.client2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

  @GetMapping("/sanitize")
  public ResponseEntity<String> sanitizePost() {
    return new RestTemplate().getForEntity("http://localhost:8080/post/1", String.class);
  }
}
