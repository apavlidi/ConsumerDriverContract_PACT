package com.apavlidi.provider;

import static java.util.Arrays.asList;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

  public static final int WRONG_ID = 3;

  public final List<Post> POSTS = asList(new Post(1, "apavlidi", "First post text"),
      new Post(2, "Bob", "Second post text"));

  @GetMapping(value = "/post/{postId}", produces = "application/json")
  public ResponseEntity<Post> retrievePost(@PathVariable Integer postId) {
    if (postId == WRONG_ID) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    final Post post = postId == POSTS.get(0).id ? POSTS.get(0) : POSTS.get(1);
    return new ResponseEntity<>(post, HttpStatus.OK);
  }
}
