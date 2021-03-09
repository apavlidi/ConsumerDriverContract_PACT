package com.apavlidi.consumer2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import java.util.HashMap;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class ClientControllerTest {

  @Rule
  public PactProviderRuleMk2 mockProvider
      = new PactProviderRuleMk2("test_provider", "localhost", 8080, this);

  @Pact(consumer = "consumer2")
  public RequestResponsePact createPactContract(PactDslWithProvider builder) {
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");

    PactDslJsonBody body = new PactDslJsonBody()
        .numberType("id", 2)
        .stringType("author", "Bob")
        .stringType("text", "Second post text");

    return builder
        .given("post exists")
          .uponReceiving("get a single post request")
          .path("/post/2")
          .method("GET")
        .willRespondWith()
          .status(200)
          .headers(headers)
          .body(body)
        .toPact();
  }

  @Test
  @PactVerification("test_provider")
  public void givenGet_whenSendRequest_shouldReturn200WithProperHeaderAndBody() {
    ClientController controller = new ClientController();

    ResponseEntity<String> response = controller.migratePost();

    assertThat(response.getStatusCode().value()).isEqualTo(200);
    assertThat(response.getHeaders().get("Content-Type").contains("application/json")).isTrue();
    assertThat(response.getBody()).contains("id", "2", "author", "Bob", "text", "Second post text");
  }

}
