package com.apavlidi.consumer3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

  @GetMapping("/consume3")
  public ResponseEntity<String> consume3() {
    return new RestTemplate().getForEntity("http://localhost:8080/post/3", String.class);
  }

}
