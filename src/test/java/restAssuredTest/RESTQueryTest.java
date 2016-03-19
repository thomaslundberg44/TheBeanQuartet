package restAssuredTest;



import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.SysUser;

public class RESTQueryTest {
	

//    @Test
//	public void resteBasedataImsirelationRestAssuredTest()
//	{
//   	System.out.println("1111111111111111111111111");
//
//	String myJson = "344930000000011";
//	RestAssured.baseURI  = "http://localhost:8080/TheBeanQuartet/rest/basedata/imsirelation";	
//
//	Response r = given()
//	.contentType("application/json").
//	body(myJson).
//    when().
//    post("");
//	
//	System.out.println("2222222222222222222222");
//	String body = r.getBody().asString();
//	System.out.println(body);
//
//	}

	

    @Test
	public void resteBasedataImsirelationRestAssuredTest()
	{
   	System.out.println("1111111111111111111111111");

	Options choice = new Options ("VEA2", "2013-01-11 17:15:00","2013-01-11 17:18:00", null);

	String myJson1 = "VEA2";
	String myJson2 = "2013-01-11 17:15:00";
	String myJson3 = "2013-01-11 17:18:00";
	RestAssured.baseURI  = "http://localhost:8080/TheBeanQuartet/rest/basedata/modelSearch";	

	Response r = given()
	.contentType("application/json").
	body(myJson1).
	body(myJson2).
	body(myJson3).
    when().
    post("");
	
	System.out.println("2222222222222222222222");
	String body = r.getBody().asString();
	System.out.println(body);

	}
    

}