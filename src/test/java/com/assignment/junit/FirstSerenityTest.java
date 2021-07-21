package com.assignment.junit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest{
	@BeforeClass
	public static void init() {
	RestAssured.baseURI="http://restcountries.eu/rest/v1";
	}
	@Test
	public void getCountryIndia() {
		String responseString=SerenityRest.given()
		.when()
		.get("/name/INDIA")
		.then()
		.log()
		.all()		
		.statusCode(200)
		.extract().asString();
		Assert.assertTrue(responseString.contains("Republic of India"));
	}
	
	@Test
	public void GetInvalidCountry() {
		String message=SerenityRest.given()
		.when()
		.get("/name/xyz")
		.then()
		.log()
		.all().assertThat()
		.statusCode(404)
		.extract()
		.path("message");
		Assert.assertTrue(message.equals("Not Found"));
	}
	
}
