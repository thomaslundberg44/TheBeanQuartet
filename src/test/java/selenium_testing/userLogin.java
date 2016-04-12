package selenium_testing;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class userLogin {

	  private WebDriver driver;
	  private String baseUrl;
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/TheBeanQuartet/";
	    
	  }

	  @Test
	  public void testUserStoriesAndLoginLogout() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.id("username")).sendKeys("Ivan");
	    driver.findElement(By.id("password")).sendKeys("1234");
	    driver.findElement(By.name("Login")).click();
	    logOut();
	    Thread.sleep(2000); 
	    
	    driver.get(baseUrl);
	    driver.findElement(By.id("username")).sendKeys("Kang");
	    driver.findElement(By.id("password")).sendKeys("1234");
	    driver.findElement(By.name("Login")).click();
	    logOut();
	    Thread.sleep(2000); 
	    
	    driver.get(baseUrl);
	    driver.findElement(By.id("username")).sendKeys("Navi");
	    driver.findElement(By.id("password")).sendKeys("1234");
	    driver.findElement(By.name("Login")).click();
	    logOut();
	    Thread.sleep(2000); 
	    
	    driver.get(baseUrl);
	    driver.findElement(By.id("username")).sendKeys("Thomas");
	    driver.findElement(By.id("password")).sendKeys("1234");
	    driver.findElement(By.name("Login")).click();
	    logOut();
	    Thread.sleep(2000); 
	    
	  }
	  
	  public void logOut()
	  {
		    driver.close();
		    System.out.println("finally quit");
	  }
}
