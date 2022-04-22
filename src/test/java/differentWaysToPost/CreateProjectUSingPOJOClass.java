package differentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import commonLibrary.JavaLibrary;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import projectLibrary.ProjectLibrary;

public class CreateProjectUSingPOJOClass {
	public static void main(String[] args) {
		JavaLibrary jLib=new JavaLibrary();
	
	baseURI="http://localhost";
	port=8084;
ProjectLibrary pLib=new ProjectLibrary("Shrey", "Infosys"+jLib.getRandom(), "Completed", 90);


given()
.body(pLib)
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
