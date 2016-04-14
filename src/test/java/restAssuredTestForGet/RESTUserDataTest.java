package restAssuredTestForGet;



import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;
import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.SysUser;

public class RESTUserDataTest {
	

    @Test
    public void restUserdataRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
        	queryParam( " ", " ").
        when().
            get("http://localhost:8080/TheBeanQuartet/rest/userdata").
        then().
        statusCode(200);
//        contentType(ContentType.JSON).
//        body("userData.id", hasItems(1)).
//        body("userData.userType", hasItems("administrator\r")).
//        body("userData.userName", hasItems("Thomas")).
//        body("userData.userPassword", hasItems("1234"));
    	System.out.println("2222222222222222222222");

    }
    

}