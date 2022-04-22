package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Ouath2_0 {
@Test
public void outh()
{
	//Create request to generate access token
	Response resp = given()
	.formParam("client_id", "SDET30CoopGSS")
	.formParam("client_secret", "395669fcbb93d3f4229197bc9334cde5")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "http://example.com")
	.formParam("code", "authorization_code")
	
	.when()
	.post("http://coop.apps.symfonycasts.com/token");
	
	//.then().log().all();
	String token = resp.jsonPath().get("access_token");
	System.out.println(token);
	
	//Here User_Id is path parameter, that's why it is closed in {}
	//Create another request and use thetoken to access API
	
	given()
	.auth().oauth2(token)
	.pathParam("USER_ID",3112)
	
	.when()
	//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
	.then().log().all();
}
}
