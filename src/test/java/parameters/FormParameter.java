package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter {
@Test
public void form()
{
	baseURI="http://localhost";
	port=8084;
	//pre requisites
	given().formParam("createdBy", "G")
	.formParam("projectName", "Bm")
	.formParam("status","On Going")
	.formParam("teamSize", 20)
	.contentType(ContentType.JSON)
	//Action
	
	.when().post("/addProject")
	//Validation
	.then().log().all();
}
}
