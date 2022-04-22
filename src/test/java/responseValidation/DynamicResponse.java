package responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class DynamicResponse {
@Test
public void resp()
{
	String expData="TY_PROJ_1607";
	baseURI="http://localhost";
	port=8084;
	
	Response resp = when().get("/projects");
	
	boolean flag=false;
	List<String>  pIDs = resp.jsonPath().get("projectId");
	for (String projectId : pIDs) {
		if(projectId.equalsIgnoreCase(expData))
		{
			flag=true;
		}
	}
	Assert.assertTrue(flag);
	System.out.println("Data verified");
	resp.then().log().all();
}
}
