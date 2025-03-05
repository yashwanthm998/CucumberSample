package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class apiTest {

    private Response response;
    private static final String BASE_URL = "https://fakerestapi.azurewebsites.net/api/v1";

    @Given("the API base URL is {string}")
    public void setBaseUrl(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }
    @And("the request body from {string} is set")
    public void setCreateRequestBody(String filename) {
        RestAssured.requestSpecification = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(new File(filename));
    }
    @And("the request body for update {string} is set")
    public void setUpdateRequestBody(String filename) {
        RestAssured.requestSpecification = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(new File(filename));
    }

    @When("I send a POST request to {string}")
    public void sendPostRequest(String users) {
        response = RestAssured.requestSpecification.when().post(users);
    }

    @When("I send a PUT request to {string}")
    public void update(String update_user){
        response=RestAssured.requestSpecification.when().put(update_user);
    }


    @When("I send a DELETE request to {string}")
    public void delete(String delete_user){
        response=RestAssured.requestSpecification.delete(delete_user);
    }

    @Then("the response status code should be 200")
    public void validateStatusCode() {
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Then("the response status code should be 200")
    public void validateStatusCode() {
        Assert.assertEquals(response.getStatusCode(),200);
    }



}



