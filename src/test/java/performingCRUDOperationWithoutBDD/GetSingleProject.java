package performingCRUDOperationWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
@Test
public void getSingleProject()
{
	//create the pre requisites
	//Perform the action
	Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1002");
	//Validate the Response
	resp.then().log().all();
	int statuscode = resp.statusCode();
	Assert.assertEquals(200,statuscode);
}
}
