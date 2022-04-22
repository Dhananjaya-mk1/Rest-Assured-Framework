package parameters;

import static io.restassured.RestAssured.baseURI;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {
@Test
public void query()
{
baseURI="https://reqres.in";
	
given().queryParam("page", 3)

.when().get("/api/users")

.then().log().all();
	
}
}
