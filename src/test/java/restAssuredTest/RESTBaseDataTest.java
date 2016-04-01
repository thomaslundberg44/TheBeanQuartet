package restAssuredTest;



import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;
import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.SysUser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.the_bean_quartet.msc_project.entities.Options;

public class RESTBaseDataTest {
	

    @Test
    public void resteBasedataRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
        	queryParam( " ", " ").
        when().
        get("http://localhost:8080/TheBeanQuartet/rest/basedata").
	    then().
	    statusCode(200).
	    contentType(ContentType.JSON).
	    body("baseDataCollection.id.", hasItems(2)).
	    body("baseDataCollection.date", hasItems("2013-01-11 17:15:00.0")).
	    body("baseDataCollection.eventCause.id.eventId", hasItems(4098)).
	    body("baseDataCollection.eventCause.id.causeCode", hasItems(0)).
	    body("baseDataCollection.eventCause.eventId", hasItems(4098)).
	    body("baseDataCollection.eventCause.causeCode", hasItems(0)). 
	    body("baseDataCollection.eventCause.description", hasItems("S1 SIG CONN SETUP-SUCCESS")).
	    body("baseDataCollection.failureClass.failureClass", hasItems(1)).
	    body("baseDataCollection.failureClass.description", hasItems("HIGH PRIORITY ACCESS")).
	    body("baseDataCollection.mccData.id.mcc", hasItems(344)).
	    body("baseDataCollection.mccData.id.mnc", hasItems(930)).
	    body("baseDataCollection.mccData.mcc", hasItems(344)).
	    body("baseDataCollection.mccData.mnc", hasItems(930)).
	    body("baseDataCollection.mccData.country", hasItems("Antigua and Barbuda")).
	    body("baseDataCollection.mccData.operator", hasItems("AT&T Wireless-Antigua AG ")).
	    body("baseDataCollection.ueTable.tac", hasItems(21060800)).
	    body("baseDataCollection.ueTable.marketingName", hasItems("VEA3")).
	    body("baseDataCollection.ueTable.manufacturer", hasItems("S.A.R.L. B  & B International")).
	    body("baseDataCollection.ueTable.accessCapability", hasItems("GSM 1800, GSM 900")).
	    body("baseDataCollection.ueTable.model", hasItems("VEA3")).
	    body("baseDataCollection.ueTable.vendorName", hasItems("S.A.R.L. B  & B International")).
	    body("baseDataCollection.cellId", hasItems(4)).
	    body("baseDataCollection.duration", hasItems(1000)).
	    body("baseDataCollection.neVersion", hasItems("11B")).
	    body("baseDataCollection.imsi", hasItems(344930000000011L)).
	    body("baseDataCollection.heir3Id", hasItems(4809532081614990336L)).
	    body("baseDataCollection.heir32Id", hasItems(8226896360947470336L)).
	    body("baseDataCollection.heir321Id", hasItems(1150444940909479936L));
		System.out.println("2222222222222222222222");
    }
    
    @Test
    public void resteBasedataModelTypeRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
        	queryParam( " ", " ").
        when().
        get("http://localhost:8080/TheBeanQuartet/rest/basedata/modelType").
        then().
	    statusCode(200).
	    contentType(ContentType.JSON).
	    body("baseDataCollection.", hasItems("VEA3"));
	 
		System.out.println("2222222222222222222222");
    }
    
    @Test
    public void resteBasedataImsiRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
        	queryParam( " ", " ").
        when().
        get("http://localhost:8080/TheBeanQuartet/rest/basedata/imsi").
	    then().
	    statusCode(200).
	    contentType(ContentType.JSON).
	    body("baseDataCollection.", hasItems(344930000000011L));
	 
		System.out.println("2222222222222222222222");
    }
    
    @Test
    public void restBasedataImsiFailureCountRestAssuredTest()
    {
    
    	given().queryParam("","").when().
    	get("http://localhost:8080/TheBeanQuartet/rest/basedata/imsiFailureCount").then().
    	statusCode(200).
    	contentType(ContentType.JSON).
    	body("baseDataCollection.", hasItems());
    }
    


}