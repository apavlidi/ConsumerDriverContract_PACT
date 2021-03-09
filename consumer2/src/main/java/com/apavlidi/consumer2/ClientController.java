package com.apavlidi.consumer2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

  @GetMapping("/migrate")
  public ResponseEntity<String> migratePost() {
    return new RestTemplate().getForEntity("http://localhost:8080/post/2", String.class);
  }
}