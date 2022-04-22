package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerToken() {
		baseURI = "https://api.github.com";

		JSONObject jobj = new JSONObject();
		jobj.put("name", "SDET-RestAssured");
		
		given().auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)

				.when()
				.post("/user/repos")

				.then().log().all();

	}
}
