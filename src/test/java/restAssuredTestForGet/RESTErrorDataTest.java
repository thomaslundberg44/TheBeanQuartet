package restAssuredTestForGet;



import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;
import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.SysUser;

public class RESTErrorDataTest {
	

    @Test
    public void resteErrordataRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
        	queryParam( " ", " ").
        when().
        get("http://localhost:8080/TheBeanQuartet/rest/errordata").
	    then().
	    statusCode(200);
//	    contentType(ContentType.JSON).
//	    body("errorDataCollection.id.", hasItems(1)).
//	    body("errorDataCollection.date", hasItems("2013-01-11 17:15:00")).
//	    body("errorDataCollection.eventId", hasItems(4099)).
//	   // body("errorDataCollection.failureClass", hasItems(null)).
//	    body("errorDataCollection.ueType", hasItems(21060800)).
//	    body("errorDataCollection.market", hasItems(344)).
//	    body("errorDataCollection.operator", hasItems(930)).
//	    body("errorDataCollection.cellId", hasItems(4)).
//	    body("errorDataCollection.duration", hasItems(1000)).
//	   // body("errorDataCollection.causeCode", hasItems(null)).
//	    body("errorDataCollection.neVersion", hasItems("11B")).
//	    body("errorDataCollection.imsi", hasItems(344930000000011L)).
//	    body("errorDataCollection.heir3Id", hasItems(4809532081614990336L)).
//	    body("errorDataCollection.heir32Id", hasItems(8226896360947470336L)).
//	    body("errorDataCollection.heir321Id", hasItems(1150444940909479936L));
		System.out.println("2222222222222222222222");
    }
    

}