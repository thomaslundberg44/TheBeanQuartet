package restAssuredTestForPost;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
public class RESTQueryTestExample {
	

    @Test
	public void resteBasedataImsirelationRestAssuredTest()
	{
   	//System.out.println("1111111111111111111111111");

	//String myJson = "\"344930000000011\"";
	String myJson = "344930000000011";

	RestAssured.baseURI  = "http://localhost:8080/TheBeanQuartet/rest/basedata/imsirelation";	
	//long startTime = System.currentTimeMillis();		
	Response r = 
			given()
	.contentType("application/json").
	body(myJson).
    when().
    post("");
   //then().statusCode(200);
//	long endTime = System.currentTimeMillis();
//	float duration = (endTime-startTime)/1000.0f;
//	System.out.print("Time took "+duration);
	System.out.println("2222222222222222222222");
	String body = r.getBody().asString();
	//System.out.println(body);
	assertTrue("baseDataCollection",body.contains("baseDataCollection"));
	assertTrue("UE CTXT RELEASE-UNKNOWN OR ALREADY ALLOCATED MME UE S1AP ID",body.contains("UE CTXT RELEASE-UNKNOWN OR ALREADY ALLOCATED MME UE S1AP ID"));
	}



//    @Test
//	public void resteBasedataImsirelationRestAssuredTest()
//	{
//   	System.out.println("1111111111111111111111111");
//
//	//Options choice = new Options ("VEA2", "2013-01-11 17:15:00","2013-01-11 17:18:00", null);
//	//String apiInput = "{\"VEA2\",\"2013-01-11 17:15:00\",\"2013-01-11 17:18:00\",\" \"}";
//	//String apiInput = "{\"option1\":\"VEA2\",\"option2\":\"2013-01-11 17:15:00\",\"option3\":\"2013-01-11 17:18:00\",\"option4\":\"\"}";
//	String apiInput = "{\"option1\":\"VEA2\",\"option2\":\"2013-01-11 17:15:00\",\"option3\":\"2013-01-11 17:18:00\",\"option4\":\"\"}";
//
//	//String myJson1 = "VEA2";
//	//String myJson2 = "2013-01-11 17:15:00";
//	//String myJson3 = "2013-01-11 17:18:00";
//	RestAssured.baseURI  = "http://localhost:8080/TheBeanQuartet/rest/basedata/modelSearch";	
//	//RestAssured.authentication = basic("username", "password");
//			//Response r =
//			given().auth().none()
//	.contentType("application/json").
//	body(apiInput).
//	//body(myJson2).
//	//body(myJson3).
//    when().
//    post("").then().statusCode(500);;
//	//then().statusCode(200);
//	
//	System.out.println("2222222222222222222222");
////	String body = r.getBody().asString();
////	System.out.println(body);
//
//	}
//	@Test
//	public void testQuery(){
//		 RequestSpecification requestSpecification = with().parameters("firstName", "John", "lastName", "Doe");
//		 ResponseSpecification responseSpecification = expect().body("greeting", equalTo("Greetings John Doe"));
//		 given(requestSpecification, responseSpecification).get("/greet");
//	}
    
}