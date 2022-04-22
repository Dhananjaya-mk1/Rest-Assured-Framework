package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class StaticResponse {
@Test
public void response()
{
	JavaLibrary jLib=new JavaLibrary();
	baseURI="http://localhost";
	port=8084;
	
	ProjectLibrary plib=new ProjectLibrary("Rocky", "KGF"+jLib.getRandom(), "Completed", 2000);
Response resp = given()
.body(plib)
.contentType(ContentType.JSON)

.when()
.post("/addProject");

String expData = "Completed";
String actData = resp.jsonPath().get("status");
Assert.assertEquals(expData, actData);
resp.then().log().all();


	
	
}
}
