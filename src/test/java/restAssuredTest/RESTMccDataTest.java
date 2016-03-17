package restAssuredTest;



import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;
import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.SysUser;

public class RESTMccDataTest {
	

    @Test
    public void restMccdataRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
        	queryParam( " ", " ").
        when().
            get("http://localhost:8080/TheBeanQuartet/rest/mccdata").
        then().
        statusCode(200).
        contentType(ContentType.JSON).
        body("data.id.mcc", hasItems(238)).
        body("data.id.mnc", hasItems(1)).
        body("data.mcc", hasItems(238)).
        body("data.mnc", hasItems(1)).
        body("data.country", hasItems("Denmark")).
        body("data.operator", hasItems("TDC-DK"));
    	System.out.println("2222222222222222222222");

    }
    

}