package differentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingJsonObj {
@Test
public void create()
{
	JavaLibrary jLib=new JavaLibrary();
	
	JSONObject jObj=new JSONObject();
	jObj.put("createdBy", "Gaavi");
	jObj.put("projectName", "All States"+jLib.getRandom());
	jObj.put("status", "Completed");
	jObj.put("teamSize",10);
	
	baseURI="http://localhost";
	port=8084;
	
	given()
	.body(jObj)
	.contentType(ContentType.JSON)

	.when()
	.post("/addProject")
	
 
	.then()
	.assertThat()
	.statusCode(201)
	.contentType(ContentType.JSON)
	.log()
	.all();
}
}
