package performingCRUDOperationWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	@Test
	public void getAllProjects() {
		// Create the pre requisites

		// perform the action
		Response resp = RestAssured.get("http://localhost:8084/projects");
		// validate the response
		resp.then().log().all();
		int statuscode = resp.statusCode();
		Assert.assertEquals(200, statuscode);
	}
}
