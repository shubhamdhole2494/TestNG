package specs;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationDemo {

	String api_key = "";
	
	RequestSpecBuilder requestBuilder;
	static RequestSpecification requestSpec;
	
	@BeforeClass
	public void setup() {
		
		//RestAssured.baseURI = "https://qa-api.reinvent2017.com";
		//RestAssured.basePath = "";
		requestBuilder =  new RequestSpecBuilder();
		requestBuilder.setBaseUri("https://qa-api.reinvent2017.com");
		requestBuilder.addHeader("x-api-key", "");
		requestSpec = requestBuilder.build();
	}
	
	@Test
	public void transpotation() {
		
		given()
		.spec(requestSpec)
		//.header("x-api-key","")
		//.header("x-api-key","")

		//.contentType("application/json")
		.when()
			.get("/admin/venues")
		.then()
			.statusCode(200)
			.log().body();
		
		
		
	}
}
