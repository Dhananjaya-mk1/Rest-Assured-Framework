package performingCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {
@Test
public void createProject()
{
	JSONObject jObj=new JSONObject();
	jObj.put("createdBy", "Gaavi");
	jObj.put("projectName", "All States");
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
