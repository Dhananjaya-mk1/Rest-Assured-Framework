package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import projectLibrary.ProjectLibrary;

public class CreateMultipleProjectInOneReq {
@Test(dataProvider="getData")

	public void createProject(String createdBy, String projectName, String status, int teamSize)
	{
	JavaLibrary jLib=new JavaLibrary();
		ProjectLibrary plib=new ProjectLibrary(createdBy, projectName+jLib.getRandom(), status, teamSize);
		baseURI="http://localhost";
		port=8084;
		
		given().body(plib).contentType(ContentType.JSON)
		
		.when().post("/addProject")

		.then().log().all();
	}

@DataProvider(name="getData")
public Object[][] data()
{
Object[][] data = new Object[3][4];

	data[0][0]="Reena";
	data[0][1]="Beng";
	data[0][2]="Created";
	data[0][3]=90;
	
	data[1][0]="Shanti";
	data[1][1]="Bhairya";
	data[1][2]="Completed";
	data[1][3]=1;
	
	data[2][0]="Vanaram";
	data[2][1]="Narachi";
	data[2][2]="On Going";
	data[2][3]=400;
	
	return data;
}
}
