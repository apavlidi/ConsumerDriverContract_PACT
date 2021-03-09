package com.apavlidi.consumer3;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.web.client.HttpClientErrorException;

public class ClientControllerTest {

  @Rule
  public PactProviderRuleMk2 mockProvider
      = new PactProviderRuleMk2("test_provider", "localhost", 8080, this);

  @Pact(consumer = "consumer3")
  public RequestResponsePact createPactContract(PactDslWithProvider builder) {
    return builder
        .given("post does not exist")
        .uponReceiving("get a single post request")
        .path("/post/3")
        .method("GET")
        .willRespondWith()
        .status(400)
        .toPact();
  }

  @Test(expected = HttpClientErrorException.BadRequest.class)
  @PactVerification("test_provider")
  public void givenGet_whenSendRequest_shouldReturn200WithProperHeaderAndBody() {
    new ClientController().processPost();
  }

}
