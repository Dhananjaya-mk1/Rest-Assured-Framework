package parameters;

import org.apache.http.impl.cookie.BasicSecureHandler;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParamaterFromGit {
@Test
public void para()
{
	baseURI="https://api.github.com";
   given()
   .pathParam("username", "swathi587")
   .queryParam("per_page", 12)
   .queryParam("page", 1)
   
   .when()
   .get("/users/{username}/repos")
   
   .then()
   .assertThat().statusCode(200).log().all();
}
}
