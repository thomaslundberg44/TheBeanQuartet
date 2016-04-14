package restAssuredTestForGet;



import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.http.ContentType;
import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.SysUser;

public class RESTSysUserTest {
	
//	Options choice = new Options ("VEA2", "2013-01-11 17:15:00","2013-01-11 17:18:00", null);
//	
//    @Test
//    public void myFirstRestAssuredTest()
//    {
//        given().
//            //queryParam("hello", 21060800).
//        	queryParam( "input", choice).
//  
//        when().
//            post("http://localhost:8080/TheBeanQuartet/modelSearch").
//        then().
//        contentType(ContentType.JSON).
//            body("result.message", equalTo("success"));
//    }
    
    @Test
    public void myFirstRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
            //queryParam("hello", 21060800).
        	queryParam( "input", "344930000000011").
        when().
            get("http://localhost:8080/TheBeanQuartet/imsirelation").
        then().
        statusCode(404);

    	System.out.println("2222222222222222222222");

    }
    
    @Test
    public void my2FirstRestAssuredTest()
    {
    	System.out.println("1111111111111111111111111");

        given().
            //queryParam("hello", 21060800).
        	queryParam( "input", "344930000000011").
        when().
            get("http://localhost:8080/TheBeanQuartet/rest/modelType").
        then().
        statusCode(404);

    	System.out.println("2222222222222222222222");

    }
	
	
//	SysUser userGod = new SysUser("God", "999", "administrator\r");
//
//    @Test
//    public void verifysysUserRestAssuredTest()
//    {
//    	System.out.println("1111111111111111111111111");
//
//        given().
//       
//        //queryParam("user", "userGod").
//            auth().form("userGod", "", new FormAuthConfig("verifyUser", "user", "")).
//
//        when().
//            post("http://localhost:8080/TheBeanQuartet/rest/user/verify").
//        then().
//        statusCode(200).
//        contentType(ContentType.JSON).
//        body("sysUserCollection.userType", equalTo("administrator\r"));
//    	System.out.println("2222222222222222222222");
//
//    }
//    @Test
//    public void sysUserverifyRestAssuredTest()
//    {
//    	System.out.println("1111111111111111111111111");
//
//        given().
//            //queryParam("hello", 21060800).
//        	queryParam( " ", " ").
//        when().
//            get("http://localhost:8080/TheBeanQuartet/rest/user").
//        then().
//        statusCode(200).
//        contentType(ContentType.JSON).
//        body("sysUserCollection.id", hasItems(1)).
//        body("sysUserCollection.userType", hasItems("administrator\r")).
//        body("sysUserCollection.userName", hasItems("Thomas")).
//        body("sysUserCollection.userPassword", hasItems("1234"));
//    	System.out.println("2222222222222222222222");
//
//    }
    

}