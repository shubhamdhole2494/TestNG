package basic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class PostRequestDemo {

	
	@BeforeClass
	public void setup() {
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}
		//https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Washington,DC&destinations=New+York+City,NY&key=YOUR_API_KEY
	//https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Washington,DC&destinations=New+York+City,NY&key=AIzaSyDHmZTn4c_Bv4jcSR1PaxToR_kmz8SVRTE
	//@Test
	public void statusCodeVerification() {
	
		given()
			.param("key", "AIzaSyDHmZTn4c_Bv4jcSR1PaxToR_kmz8SVRTE")
		.when()
			.get("/distancematrix/json")
		.then()	
			.statusCode(200);
	}
	@Test
	public void getResponseBody() {
		
		Response res =
		given()
			.param("units", "imperial")
			.param("origins", "Washington,DC")
			.param("destinations", "New+York+City,NY")
			.param("key", "AIzaSyDHmZTn4c_Bv4jcSR1PaxToR_kmz8SVRTE")
		.when()
			.get("/distancematrix/json");
		
		System.out.println(res.body().asString());
		
	}
}
