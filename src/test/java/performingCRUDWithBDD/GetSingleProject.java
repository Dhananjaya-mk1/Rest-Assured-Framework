package performingCRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetSingleProject {
@Test
public void getSingleProject()
{
	
	
	baseURI="http://localhost";
	port=8084;
	
	when()
	.get("/projects/TY_PROJ_1404")
	
	.then()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log()
	.all();
}
}
