package restAssuredTestForPost;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.the_bean_quartet.msc_project.entities.SysUser;

public class UserCRUDServiceTest {
	
//	@Test
//	public void addUserTest(){
//		// Initializing Rest API's URL
//		String apiUrl = "http://localhost:8080/TheBeanQuartet/rest/user";
//		
//		System.out.println("11111111111111111");
//		// Initializing payload or API body
////		String apiInput = "{\"id\":0,\"username\":\"Test\",\"password\":\"1234\",\"usertype\":"
////				+ "\"System Administrator\"}";
//		SysUser apiInput = new SysUser("Test","1234","Admin");
//		System.out.println("22222222222222222222");
//
//		// Building request using requestSpecBuilder
//		RequestSpecBuilder builder = new RequestSpecBuilder();
//		System.out.println("22222222222222222222");
//
//		builder.setContentType("application/json; charset= UTF-8");
//		System.out.println("22222222222222222222");
//		
//		builder.setBody(apiInput);
//		System.out.println("22222222222222222222");
//		
//		RequestSpecification requestSpec = builder.build();
//		// Making post request with authentication
//		Response response = given().spec(requestSpec).when().post(apiUrl);
//
//		// Automatically check the result with assert methods
//		// The server has fulfilled the request 
//		// but does not need to return an entity-body, 
//		// and might want to return updated meta information.
//		assertEquals(204, response.getStatusCode());
//	
//		//assertEquals(400, response.getStatusCode());
//
//	}
	
//	@Test
//	public void checkUserExistenceTest(){
//		// Initializing Rest API's URL
//				String apiUrl = "http://localhost:8080/TheBeanQuartet/rest/user/verify";
//				// Initializing payload or API body
//				String apiInput = "Kang";
//				// Building request using requestSpecBuilder
//				RequestSpecBuilder builder = new RequestSpecBuilder();
//				builder.setBody(apiInput);
//				builder.setContentType("application/json; charset= UTF-8");
//				RequestSpecification requestSpec = builder.build();
//				// Making post request with authentication
//				Response response = given().spec(requestSpec).when().post(apiUrl);
//				String returnedContent = response.getBody().asString();				
//				// Automatically check the result with assert methods
//				assertEquals(200, response.getStatusCode());
//				assertEquals("false", returnedContent);
//				
//				apiInput = "Emer";
//				builder.setBody(apiInput);
//				builder.setContentType("application/json; charset= UTF-8");
//				requestSpec = builder.build();
//				// Making post request with authentication
//				response = given().spec(requestSpec).when().post(apiUrl);
//				returnedContent = response.getBody().asString();				
//				// Automatically check the result with assert methods
//				assertEquals(200, response.getStatusCode());
//				assertEquals("false", returnedContent);		
//	}
	
//	@Test
//	public void checkUserTypeTest(){
//		// Initializing Rest API's URL
//		String apiUrl = "http://localhost:8080/maven_Project/rest/users/checktype";
//		// Initializing payload or API body
//		User apiInput = new User("Yang","1234");
//		// Building request using requestSpecBuilder
//		RequestSpecBuilder builder = new RequestSpecBuilder();
//		builder.setBody(apiInput);
//		builder.setContentType("application/json; charset= UTF-8");
//		RequestSpecification requestSpec = builder.build();
//		// Making post request with authentication
//		Response response = given().spec(requestSpec).when().post(apiUrl);
//		Integer expectedContent = 1;
//		Integer returnedContent = Integer.parseInt(response.getBody().asString());
//		
//		// Automatically check the result with assert methods
//		assertEquals(200, response.getStatusCode());
//		assertEquals(expectedContent, returnedContent);
//		
//		// Initializing payload or API body
//		apiInput = new User("Daniel","1234");
//		// Building request using requestSpecBuilder
//		builder.setBody(apiInput);
//		builder.setContentType("application/json; charset= UTF-8");
//		requestSpec = builder.build();
//		// Making post request with authentication
//		response = given().spec(requestSpec).when().post(apiUrl);
//		expectedContent = 2;
//		returnedContent = Integer.parseInt(response.getBody().asString());
//		
//		// Automatically check the result with assert methods
//		assertEquals(200, response.getStatusCode());
//		assertEquals(expectedContent, returnedContent);
//	}
	
//	@Test
//	public void getUsersTest(){
////		RestAssured.baseURI = "http://localhost:8080/maven_Project/rest/users";
////		
////		when().get().then().statusCode(200)
////		.body("[0]", Matchers.equalTo(1));
//		
//		Response response = get("http://localhost:8080/TheBeanQuartet/rest/user");
//		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
//		JSONArray result = JSONResponseBody.getJSONArray("sysUserCollection");
//		
//		System.out.println(result);
//		System.out.println("The size of returned data is " + result.length()
//				+ " !!!");
//		
//		System.out.println(result.get(0));
//		
//		int id = result.getJSONObject(0).getInt("id");
//		String userName = result.getJSONObject(0).getString("userName");
//		String userPassword = result.getJSONObject(0).getString("userPassword");
//		String userType = result.getJSONObject(0).getString("userType");
//		System.out.println(id);
//		System.out.println(userName);
//		System.out.println(userPassword);
//		System.out.println(userType);
//		
//
//		// Automatically check the resulte with assert methods
//		assertEquals(200, response.getStatusCode());
////		assertEquals("{\"id\":1,\"username\":\"Thomas\",\"usertype\":\"Admin\","
////				+ "\"password\":\"1234\"}",
////				result.get(0).toString());
//		assertEquals(1, id);
//		assertEquals("Thomas", userName);
//		assertEquals("1234", userPassword);
//		assertEquals("Admin", userType);
//	}
	
//	@Test
//	public void loginTest(){
//		
//		// Initializing Rest API's URL
//		String apiUrl = "http://localhost:8080/maven_Project/rest/users/login";
//		// Initializing payload or API body
//		User apiInput = new User("Yang","1234");
//		
//		// Building request using requestSpecBuilder
//		RequestSpecBuilder builder = new RequestSpecBuilder();
//		builder.setBody(apiInput);
//		builder.setContentType("application/json; charset= UTF-8");
//		RequestSpecification requestSpec = builder.build();
//		// Making post request with authentication
//		Response response = given().spec(requestSpec).when().post(apiUrl);
//		String expectedContent = "true";
//		String returnedContent = response.getBody().asString();		
//		// Automatically check the result with assert methods
//		assertEquals(200, response.getStatusCode());
//		assertEquals(expectedContent, returnedContent);
//		
//		apiInput = new User("Test1","1234");
//		builder.setBody(apiInput);
//		builder.setContentType("application/json; charset= UTF-8");
//		requestSpec = builder.build();
//		// Making post request with authentication
//		response = given().spec(requestSpec).when().post(apiUrl);
//		expectedContent = "false";
//		returnedContent = response.getBody().asString();		
//		// Automatically check the result with assert methods
//		assertEquals(200, response.getStatusCode());
//		assertEquals(expectedContent, returnedContent);
//		
//	}

}
