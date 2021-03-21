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

  public static final Post POST_1 = new Post(0, "Alice", "First post text");
  public static final Post POST_2 = new Post(1, "Bob", "Second post text");

  public final List<Post> POSTS = asList(POST_1, POST_2);

  @GetMapping(value = "/post/{postId}", produces = "application/json")
  public ResponseEntity<Post> retrievePost(@PathVariable Integer postId) {
    try {
      final Post post = POSTS.get(postId);
      return new ResponseEntity<>(post, HttpStatus.OK);
    } catch (IndexOutOfBoundsException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
