package com.assignment.cucumber.steps;

import org.junit.Assert;

import com.assignment.testbase.TestBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

public class Steps extends TestBase {
ValidatableResponse response;
	@When("^I send a GET request with parameter \"([^\"]*)\"$")
	public void i_send_a_GET_request_with_parameter(String queryparameter) throws Throwable {
		response = SerenityRest.given()
		.when()
		.get(queryparameter)
		.then()
		.log()
		.all();
	}

	@Then("^Status Code is (\\d+)$")
	public void status_Code_is(int responsecode) throws Throwable {
		response.statusCode(responsecode);
	}
}
