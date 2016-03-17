package restAssuredTest;



import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;
import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.SysUser;

public class RESTUEDataTest {
	

    @Test
    public void restUEDataRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
        	queryParam( " ", " ").
        when().
            get("http://localhost:8080/TheBeanQuartet/rest/UEData").
        then().
        statusCode(200).
        contentType(ContentType.JSON).
        body("uedataCollection.tac", hasItems(100100)).
        body("uedataCollection.marketingName", hasItems("G410")).
        body("uedataCollection.manufacturer", hasItems("Mitsubishi")).
        body("uedataCollection.accessCapability", hasItems("GSM 1800, GSM 900")).
        body("uedataCollection.model", hasItems("G410")).
        body("uedataCollection.vendorName", hasItems("Mitsubishi"));
    	System.out.println("2222222222222222222222");

    }
    

}