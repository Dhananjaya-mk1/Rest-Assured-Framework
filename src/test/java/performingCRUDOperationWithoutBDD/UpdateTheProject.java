package performingCRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateTheProject {
@Test
public void updateproject(){
	
	//Create the pre requisites
	JSONObject jObj=new JSONObject();
	jObj.put("createdBy", "Swathi G S");
	jObj.put("projectName", "Xylem12");
	jObj.put("status", "Completed"); 
	jObj.put("teamSize", 35);
	
	RequestSpecification req = RestAssured.given();
	req.body(jObj);
	req.contentType(ContentType.JSON);
	
	//perform the action
	Response response = req.put("http://localhost:8084/TY_PROJ_1403");
	//Validate the response
	System.out.println(response.contentType());
	System.out.println(response.asString());
	System.out.println(response.prettyPrint());
	System.out.println(response.prettyPeek());
}
}
