# Consumer Driven Contract Testing
The project showcase how to do Consumer-Driven Contract testing using Pact. Please find more on the official site [here](https://pact.io/)

## Overview
In the project, you will find three modules. The `provider` module is the provider that exposes a REST endpoint that other clients use. The `consumer1`, `consumer2` & `consumer3`. 
are using that REST endpoint that the provider exposes. Imagine that in a microservice architecture there are more consumers and providers. To simplify the project
here we just only three "systems". Both consumers and provider have their test to verify that the contract is respected on both sides and it will prevent from
any incident happening.

### How to run

<details><summary><b>Create the contract for consumer1 ~ provider</b></summary>
<p>

1. Navigate to the consumer1. Run `cd consumer1`
2. Run `mvn test` to run the tests of the consumer1 module. The command will producer the contract between consumer1 and provider based on the assumptions that 
consumer1 is making. The contract file can be found in the folder called `pactFiles`.

</p>
</details>



<details><summary><b>Create the contract for consumer2 ~ provider</b></summary>
<p>

1. Navigate to the consumer2. Run `cd consumer2`
2. Run `mvn test` to run the tests of the consumer2 module. The command will producer the contract between the consumer2 and provider based on the assumptions that the consumer2 is making. The contract file can be found in the folder called `pactFiles` along with the other contracts.

</p>
</details>

<details><summary><b>Create the contract for consumer3 ~ provider</b></summary>
<p>

1. Navigate to the consumer3. Run `cd consumer3`
2. Run `mvn test` to run the tests of the consumer3 module. The command will producer the contract between the consumer3 and provider based on the assumptions that the consumer3 is making. Consumer3 is kinda special because it tests a different state of the system where the provider is throwing a `BAD_REQUEST` when it's receiving a postId as 3 in the URL parameter.

</p>
</details>

<details><summary><b>Verify the contracts on the provider side.</b></summary>
<p>

1. Navigate to the provider. Run `cd provider`
2. Run `mvn test` to run the tests of the provider module. The command will retrieve the contracts from the `pactFiles` that both consumers created and it will verify the assumptions that they made by testing the actual REST endpoint.

</p>
</details>

### Things to consider
You have to run both consumer and provider tests before you deploy any change to make sure you are not breaking the contract between those two.
There are different ways of accomplishing that in your pipeline before you push to production: 
  1. Manually testing it.
  2. Directly (If both consumer and provider live in the same repository)
  3. Pact Broker web-hook.
  4. Swagger validator
  
  The pact files can be configured to be shared with the following options
  - File System (which is used in this project)
  - URL
  - Pact Broker
