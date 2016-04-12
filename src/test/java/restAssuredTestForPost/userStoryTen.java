package restAssuredTestForPost;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.the_bean_quartet.msc_project.entities.Options;

public class userStoryTen {
   
	
	@Test
	public void testUserStoryTen()
	{
   	System.out.println("1111111111111111111111111");
	RestAssured.baseURI  = "http://localhost:8080/TheBeanQuartet/rest/basedata/eventCauseSearch";	

	//String myJson = "\"VEA3\"";
	//String myJson = "VEA3";
	//Object myJson = "{\"option1\":\"VEA2\",\"option2\":\"\",\"option3\":\"\",\"option4\":\"\"}";
	String myJson = "{\"option1\":\"VEA2\",\"option2\":\"\",\"option3\":\"\",\"option4\":\"\"}";

	//String myJson = "{\"Options\":\"VEA2\"}";
   //	Options choice = new Options ("VEA2","","","");
   	
	// Building request using requestSpecBuilder
	RequestSpecBuilder builder = new RequestSpecBuilder();
	System.out.println("22222222222222222222");

	builder.setContentType("application/json; charset= UTF-8");
	System.out.println("22222222222222222222");
	
	builder.setBody(myJson);
	RequestSpecification requestSpec = builder.build();
	Response response = given().spec(requestSpec).when().post("");

	long startTime = System.currentTimeMillis();		
//	Response response = 
//			given()
//	.contentType("application/json").
//	body(myJson).
//    when().
//    post("");
 //  then().statusCode(200);
	long endTime = System.currentTimeMillis();
	float duration = (endTime-startTime)/1000.0f;
	System.out.print("Time took "+duration);
	System.out.println("2222222222222222222222");
	String body = response.getBody().asString();
	System.out.println(body);
//	assertTrue("baseDataCollection",body.contains("baseDataCollection"));
//	assertTrue("UE CTXT RELEASE-UNKNOWN OR ALREADY ALLOCATED MME UE S1AP ID",body.contains("UE CTXT RELEASE-UNKNOWN OR ALREADY ALLOCATED MME UE S1AP ID"));
	}
}
