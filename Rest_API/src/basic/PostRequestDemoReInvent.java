package basic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class PostRequestDemoReInvent {

	
	@BeforeClass
	public void setup() {
		
		RestAssured.baseURI = "https://qa-api.reinvent2017.com";
		//RestAssured.basePath = "";
	}
		//https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Washington,DC&destinations=New+York+City,NY&key=YOUR_API_KEY
	//https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Washington,DC&destinations=New+York+City,NY&key=AIzaSyDHmZTn4c_Bv4jcSR1PaxToR_kmz8SVRTE
	//@Test(priority=1)
	public void credentials() {
	
		Response res = given()
			.body("{\r\n" + 
					"    \"IdentityId\": \"us-east-1:1901b91a-433c-403f-ba06-cf3eefe19b3e\",\r\n" + 
					"    \"Token\": \"eyJraWQiOiJ1cy1lYXN0LTExIiwidHlwIjoiSldTIiwiYWxnIjoiUlM1MTIifQ.eyJzdWIiOiJ1cy1lYXN0LTE6MTkwMWI5MWEtNDMzYy00MDNmLWJhMDYtY2YzZWVmZTE5YjNlIiwiYXVkIjoidXMtZWFzdC0xOjdiODY2MGM5LWFhNmMtNDgwZi1iNThjLWM3M2NjZjEyYWJkNyIsImFtciI6WyJhdXRoZW50aWNhdGVkIiwicWEtbG9naW4ubGFueW9uLmN2ZW50IiwicWEtbG9naW4ubGFueW9uLmN2ZW50OnVzLWVhc3QtMTo3Yjg2NjBjOS1hYTZjLTQ4MGYtYjU4Yy1jNzNjY2YxMmFiZDc6QjNDN0UwNjYzMzQ5MTA5N0Q2MkQzRDdCNjY3NDdDMjMiXSwiaXNzIjoiaHR0cHM6Ly9jb2duaXRvLWlkZW50aXR5LmFtYXpvbmF3cy5jb20iLCJleHAiOjE1MzU0NzMxNTEsImlhdCI6MTUzNTM4Njc1MX0.Zijgt0kh-r15VCzkOdP_uu92txkUxzr2SZ3b1WesFuYQDN8nhYLtQxRhijzMGyKP4A0gygG-PQSeGy0ef6zh1kDk9ljxRVGyC07v8uCDznsuZ9fMTwCSx4Wder5h1sIx5UXZsr8aiOgIB3rvY5W2C9RTdaM05mTrFU22w2l7lpUV2GbycQyiGi1jXxkJ1ltdgfIyEtp7l_6F97vUsAovyPzdt_ocCHjBjBN751LyqaIVyAcn6uaP9gSqkqbZmElZlKd2NfN2k-zJKLiKbBWAuVF75tCZEOPz49e5iOW-TYapXxwANkweXgxtsWg5Tx8xPY-D-ST_ZIJPBsjfWlkTcg\"\r\n" + 
					"}")
			
		.when()
			.post("/credentials")
		.then()	
			.statusCode(200)
			.extract().response();
		
		String accesskey = res.path("data.stsTokenData.accessKeyId");
		System.out.println(accesskey);
		
		String resString = res.asString();
		System.out.println(resString);
		
	}
	//@Test(priority=2)
	public void Runtoken() {
		
		given()
		.contentType("application/json")
		.body("{\r\n" + 
				"	\"userName\": \"kradkar\",\r\n" + 
				"	\"password\": \"mobTest123!\"\r\n" + 
				"}")
		
		.when()
			.post("/users/token")
		.then()
			.statusCode(200);
		
	}
	
	@Test(priority=1)
	public void transpotation() {
		
		given()
		
		.header("accessKeyId","ASIARQ5UAMJ5IUTZMTPV")
		.header("secretAccessKey","Anfc5BHlm6CuIRs12SXwI9obRvxnGnpDYyxyNvZq")
		.header("sessionToken","FQoGZXIvYXdzEJP//////////wEaDMhPeQngKbVCgTnxRCLwBPZvKrhRKqbK7t9mrfKnf8YnbJBlJVGEOJfjxP5h069Fc+eST4Fct1d/XQfWbHfGwn/6xkm0hgjDRGFOMQDuEf509ZOdlja7wZUxhbUR8ulGrxTfSTd0VYeaC0K3apfDIUgxSGp80HVD6Jioy0E83Zcyx48JtKRZLpnNGYNSoSze37bcKouFvAlrlcgGnBVa+x58Ci5weBAwvMWot6WbT/9ovLz35le/1M0TV2P113iNl0SSGCH1sQw2S9WT9A8+iz9qfbuw95gzBIg4oL9clyVYHNimTxzgQP+i+cLcpijvrlV10d8RIT4XYDhYOPBdYhW5o2mBv2BuSbjVpZ1bRJ4+4Ff3+Wqgz+RY7/yjxhUHTRbMMCxvgpsX5Vg9qouO6RAbD4+2rrGs2MDsqN0L24UF8k9/PvipnlOqGZv3eJ/jLYGfVx2g2kM5jwO91fMfmKaBoz6meouv8JcsEBNeNsXUM8an3D+H5MmC6rHysQtqUcIYS/WW3cWgIsTNyA4bLHgoYz4c0tRaduodzuKvgNRdJWL7Oqkd+FJ69jwAHTm8jeawvMcyTjkjHMSb/AfK/V+2iCuQBGICq9YkEF0GOXG1cLTj0aaW5F5KSu5jJmLZHSY6HCYaCAhnhkR9Oqvj8neXsfSbT7OgIz5I5oof2NtOtlQbAgCKZd4byhjsqfpExOtjX3oXlGO/lT+jnXEe4py+tp7liWhWdlsrk8e5FH2vuJfjWRkaieslSs1XBrr/xDFaqEmuO6fqoB91u5rLHnjwtDjf6Z2SI9asCNAGMrWWP5zkh/20wDi0lf4uMOetEeYUWKBV3npz66MsSbgEIiiW8pDcBQ==")
		.header("Accept","ver=1.0")
		.contentType("application/json")
		.when()
			.get("/routes?includeRouteDetails=false")
		.then()
			.statusCode(200);
		
		
		
	}
	
}
