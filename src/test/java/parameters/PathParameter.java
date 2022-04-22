package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
@Test
public void path()
{
	baseURI="http://localhost";
	port=8084;
given().pathParam("pid", "TY_PROJ_1607")

.when().get("/projects/{pid}")

.then().log().all();
}
}
