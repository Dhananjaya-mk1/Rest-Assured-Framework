package differentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJsonFile {
@Test
public void create()
{
File file=new File(".\\Data.json");
baseURI="http://localhost";
port=8084;

given()
.body(file)
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
