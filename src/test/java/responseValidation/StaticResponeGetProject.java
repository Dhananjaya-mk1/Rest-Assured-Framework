package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponeGetProject {
@Test
public void staticresp()
{
	baseURI="http://localhost";
	port=8084;
	String expData = "Completed";
	
	Response resp = when().get("projects");
	String actData = resp.jsonPath().get("[5].status");
	Assert.assertEquals(expData, actData);
	resp.then().log().all();
}
}
