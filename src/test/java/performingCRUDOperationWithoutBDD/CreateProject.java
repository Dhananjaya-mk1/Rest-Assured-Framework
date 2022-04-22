package performingCRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
@Test
public void createProject()
{
	//create pre requisites
JSONObject jObj=new JSONObject();
jObj.put("createdBy", "Swathi G S");
jObj.put("projectName", "Xylem12");
jObj.put("status", "On Going"); 
jObj.put("teamSize", 21);

RequestSpecification req = RestAssured.given();
req.body(jObj);
req.contentType(ContentType.JSON);
//Perform the action
Response response = req.post("http://localhost:8084/addProject");
	//Validate the response
System.out.println(response.contentType());
System.out.println(response.asString());
System.out.println(response.prettyPrint());
System.out.println(response.prettyPeek());
}
}
