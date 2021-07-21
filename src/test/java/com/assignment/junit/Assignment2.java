package com.assignment.junit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class Assignment2{
	@BeforeClass
	public static void init() {
	RestAssured.baseURI="http://restcountries.eu/rest/v1";
	}
	@Test
	public void NorwayTest() {
		String capital=SerenityRest.given()
		.when()
		.get("/name/Norway")
		.then()
		.log()
		.all()		
		.statusCode(200)
		.extract()
		.path("findAll{it.capital=='Oslo'}.capital.get(0)").toString();
		Assert.assertTrue(capital.equals("Oslo"));
	}
	
	
}