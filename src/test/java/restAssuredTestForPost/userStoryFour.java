package restAssuredTestForPost;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class userStoryFour {
	

    @Test
	public void testUserStoryFour()
	{
   	System.out.println("1111111111111111111111111");

	//String myJson = "\"344930000000011\"";
	String myJson = "344930000000011";

	RestAssured.baseURI  = "http://localhost:8080/TheBeanQuartet/rest/basedata/imsirelation";	
	long startTime = System.currentTimeMillis();		
	Response r = 
			given()
	.contentType("application/json").
	body(myJson).
    when().
    post("");
   //then().statusCode(200);
	long endTime = System.currentTimeMillis();
	float duration = (endTime-startTime)/1000.0f;
	System.out.print("Time took "+duration);
	System.out.println("2222222222222222222222");
	String body = r.getBody().asString();
	//System.out.println(body);
	assertTrue("baseDataCollection",body.contains("baseDataCollection"));
	assertTrue("UE CTXT RELEASE-UNKNOWN OR ALREADY ALLOCATED MME UE S1AP ID",body.contains("UE CTXT RELEASE-UNKNOWN OR ALREADY ALLOCATED MME UE S1AP ID"));
	}
}
