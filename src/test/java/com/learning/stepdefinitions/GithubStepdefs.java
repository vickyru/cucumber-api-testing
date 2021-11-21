package com.learning.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class GithubStepdefs {

    RequestSpecification request;
    Response response;

    @Given("User hit the get api (.*)$")
    public void userHitTheGithubApiUrl(String url) {
        baseURI= url;
        request = given();
    }


    @When("User send the get all repository request")
    public void userSendTheGetAllRepositoryRequest() {
        String path = "/api/users?page=2";
        response = request.get(path).then().extract().response();
    }

    @Then("User receive the response (.*)$")
    public void userReceiveTheResponseResponseCode(int code) {
        Assert.assertEquals(response.getStatusCode(), code );
        Assert.assertTrue(response.getBody().print().contains("email"));
    }
}
