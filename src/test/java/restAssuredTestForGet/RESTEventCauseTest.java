package restAssuredTestForGet;



import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;
import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.SysUser;

public class RESTEventCauseTest {
	

    @Test
    public void restFailuresRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
        	queryParam( " ", " ").
        when().
        get("http://localhost:8080/TheBeanQuartet/rest/eventCause").
	    then().
	    statusCode(200).
	    contentType(ContentType.JSON).
	    body("eventCauseCollection.id.causeCode", hasItems(0)).
	    body("eventCauseCollection.id.eventId", hasItems(4097)).
	    body("eventCauseCollection.causeCode", hasItems(0)).
	    body("eventCauseCollection.eventId", hasItems(4097)).
	    body("eventCauseCollection.description", hasItems("RRC CONN SETUP-SUCCESS"));
		System.out.println("2222222222222222222222");
    }
    

}