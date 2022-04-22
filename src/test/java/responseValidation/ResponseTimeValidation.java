package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

public class ResponseTimeValidation {
@Test
public void resp()
{
	baseURI="http://localhost";
	port=8084;
	
	Response resp = when().get("/projects");
	
	long ti = resp.time();
	System.out.println(ti);
	resp.then().assertThat().time(Matchers.comparesEqualTo(ti), TimeUnit.MILLISECONDS)
	.log().all();
	
	//resp.then().assertThat().time(Matchers.lessThan(20000L), TimeUnit.MILLISECONDS).log().all();
	//resp.then().assertThat().time(Matchers.greaterThan(20L), TimeUnit.MILLISECONDS).log().all();
}
}
