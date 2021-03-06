package com.apavlidi.provider;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@RunWith(PactRunner.class)
@Provider("test_provider")
@PactFolder("../pactFiles")
public class PactProviderTest {

  @TestTarget
  public final Target target = new HttpTarget("http", "localhost", 8080, "/");

  @BeforeClass
  public static void start() {
    ConfigurableWebApplicationContext application = (ConfigurableWebApplicationContext)
        SpringApplication.run(ProviderApplication.class);
  }

  @State("post exists")
  public void postExists() { }

  @State("post does not exist")
  public void postDoesNotExist() { }
}