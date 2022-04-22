package performingCRUDOperationWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
@Test
public void deleteProject()
{
//Pre requisites
	//perform the action
	Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1002");
	//validate the response
	resp.then().log().all();
	int statuscode = resp.statusCode();
	Assert.assertEquals(204,statuscode);

}
}
