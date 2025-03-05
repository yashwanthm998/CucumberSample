Feature: User API Testing

  Scenario: Create a new user
    Given the API base URL is "https://fakerestapi.azurewebsites.net/api/v1"
    And the request body from "src/test/resources/chain.json" is set
    When I send a POST request to "/Users"
    Then the response status code should be 200

    Scenario: Update the existing user
      Given the API base URL is "https://fakerestapi.azurewebsites.net/api/v1"
      And the request body for update "src/test/resources/update.json" is set
      When I send a PUT request to "/Users/636"
      Then the response status code should be 200

    Scenario: Delete an existing user
      Given the API base URL is "https://fakerestapi.azurewebsites.net/api/v1"
      When I send a DELETE request to "/Users/636"
      Then the response status code should be 200