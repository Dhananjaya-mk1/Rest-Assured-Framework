package differentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateprojectUsingHashMap {
@Test
public void create()
{
	JavaLibrary jLib=new JavaLibrary();
	HashMap map=new HashMap();
 map.put("createdBy", "Raj");
 map.put("projectName", "Wipro"+jLib.getRandom());
 map.put("status", "Completed");
 map.put("teamSize", 67);
	
	baseURI="http://localhost";
	port=8084;
	
	given()
	.body(map)
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
