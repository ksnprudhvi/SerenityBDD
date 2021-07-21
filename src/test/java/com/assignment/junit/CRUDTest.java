package com.assignment.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.assignment.model.RegisterCustomer;
import com.assignment.testbase.TestBase;
import com.assignment.utils.TestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class CRUDTest extends TestBase {
	public String firstName = TestUtils.getRandomValue() + "Jaya";
	private String lastName = TestUtils.getRandomValue() + "Surya";
	private String username = TestUtils.getRandomValue() + "JayaSurya";
	private String password = "king";
	private String email = TestUtils.getRandomValue() + "js@test.com";

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer/register";
	}

	@Title("This will create new customer")
	@Test
	public void createnewUser() {
		RegisterCustomer customer = new RegisterCustomer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setEmail(email);
		SerenityRest.given().
		contentType(ContentType.JSON).
		when().
		body(customer)
		.post().
		then().and().
		log().
		all().
		statusCode(201);
	}
	
	@Title("This will create new customer")
	@Test
	public void createUserAlreadyExisted() {
		RegisterCustomer customer = new RegisterCustomer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setEmail(email);
		SerenityRest.given().contentType(ContentType.JSON).
		log().all().
		when().
		body(customer).
		post().
		then().
		and().log().
		all().
		statusCode(400);
	}
}
