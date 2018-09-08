package basic;

import static io.restassured.RestAssured.given;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class validateResponse {
	
	@BeforeClass
	public void setup() {
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}
		
	@Test
	public void statusCodeVerification() {
	
		given()
			.param("units", "imperial")
			.param("origins", "Washington,DC")
			.param("destinations", "New+York+City,NY")
			.param("key", "AIzaSyDHmZTn4c_Bv4jcSR1PaxToR_kmz8SVRTE")
		.when()
			.get("/distancematrix/json")
		.then()	
			.statusCode(200)
			.and()
			.body("rows[0].elements[0].distance.text", equalTo("225 mi"))
			.contentType(ContentType.JSON);
	}

}
