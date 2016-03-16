package restAssuredTest;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RESTTest {
	
    @Test
    public void myFirstRestAssuredTest()
    {
        given().
            //queryParam("hello", 21060800).
        	queryParam( "uetypes", "VEA2").
            queryParam("dateStart", "2013-01-11 17:15:00").
            queryParam("dateEnd", "2013-01-11 17:18:00").

        when().
            post("http://localhost:8080/TheBeanQuartet/userStoryEightSearchByPhoneModel.html").
        then().
            body("title", equalTo("The Page Title"));
    }
    
//    @Test
//    public void myFirstRestAssuredTest()
//    {
//        given().
//            queryParam("name", "James").
//        when().
//            get("http://yourwebsiteaddress/api").
//        then().
//            body("title", equalTo("The Page Title"));
//    }

}