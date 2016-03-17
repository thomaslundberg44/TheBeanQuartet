package restAssuredTest;



import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;
import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.SysUser;

public class RESTFailureTest {
	

    @Test
    public void restEventCauseRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
        	queryParam( " ", " ").
        when().
        get("http://localhost:8080/TheBeanQuartet/rest/failures").
	    then().
	    statusCode(200).
	    contentType(ContentType.JSON).
	    body("failureDataCollection.failureClass", hasItems(0)).
	    body("failureDataCollection.description", hasItems("EMERGENCY"));
		System.out.println("2222222222222222222222");

    }
    

}