package com.assignment.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://restcountries.eu/rest/v2";

	}
}
