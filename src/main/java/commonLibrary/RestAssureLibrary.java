package commonLibrary;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * This library consist of methods related to Rest Assured
 * @author Swathi G S
 *
 */
public class RestAssureLibrary {

	public String getJsonPath( Response resp,String JsonPath)
	
	{
		String value = resp.jsonPath().get(JsonPath);
		return value;
	}
}
