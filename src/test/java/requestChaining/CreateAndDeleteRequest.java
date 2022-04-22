package requestChaining;

import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import projectLibrary.ProjectLibrary;

public class CreateAndDeleteRequest {
	@Test
	public void create()
	{
		JavaLibrary jLib=new JavaLibrary();
		ProjectLibrary plib=new ProjectLibrary("GSS", "Amdocs"+jLib.getRandom(), "Created", 12);
		
		baseURI="http://localhost";
		port=8084;
		
		Response resp = given().body(plib).contentType(ContentType.JSON)
				.when().post("/addProject");
		
		//Capture the prject id
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		//Create a get request and pass proId as path parameter 
		given().pathParam("pid", proId)
		.when().delete("/projects/{pid}")
		.then().assertThat().statusCode(204).log().all();
	}
}
