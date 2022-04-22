package performingCRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProject {
@Test
public void updateproject()
{
	JSONObject jObj=new JSONObject();
	jObj.put("createdBy", "Gaavi");
	jObj.put("projectName", "All States162681");
	jObj.put("status", "Completed");
	jObj.put("teamSize",78);
	
	baseURI="http://localhost";
	port=8084;
	
	given()
	.body(jObj)
	.contentType(ContentType.JSON)
	
	.when()
	.put("/projects/TY_PROJ_1404")
	
	.then()
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log()
	.all();
	
}
}
