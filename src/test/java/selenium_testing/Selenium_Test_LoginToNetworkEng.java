package selenium_testing;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Test_LoginToNetworkEng {

	  private WebDriver driver=null;
	  private String baseUrl;
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/TheBeanQuartet/";
	    
	  }

	  @Test
	  public void testUserStoriesAndLoginLogout() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.id("username")).sendKeys("Navi");
	    driver.findElement(By.id("password")).sendKeys("1234");
	    driver.findElement(By.name("Login")).click();
	    
	    driver.findElement(By.className("dropdown-menu"));
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println("dropdown-menu");
	    
	    
	    driver.findElement(By.id("Network manager")).click();
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println("Network manager");
	    
	    driver.findElement(By.id("userStory9")).click();
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println("story-9");
	    String story9Detail = driver.findElement(By.id("msgbox")).getText();
	    Assert.assertTrue(story9Detail.equals("Counts, for each IMSI, the number of call failures and their total duration during a given time period."));
	    
	    driver.findElement(By.id("Network manager")).click();
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println("Network manager");
	    
	    driver.findElement(By.id("userStory10")).click();
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println("story-10");
	    String story10Detail = driver.findElement(By.id("msgbox")).getText();
	    Assert.assertTrue(story10Detail.equals("Display For A Given Model Unique Failure, EventId and Cause Code Combination And Number Of Occurences."));
	    
	    
	    driver.findElement(By.id("Network manager")).click();
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println("Network manager");
	    
	    driver.findElement(By.id("userStory11")).click();
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println("story-11");
	    String story11Detail = driver.findElement(By.id("msgbox")).getText();
	    Assert.assertTrue(story11Detail.equals("Display Top 10 Market/Operator/Cell ID combinations that had call failures during a time period"));
	    
	    
	    driver.findElement(By.id("support manager")).click();
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println("support manager");
	    
	    
	    driver.findElement(By.id("userStory7")).click();
	    System.out.println("story-7");
	    TimeUnit.SECONDS.sleep(3);
	    String story7Detail = driver.findElement(By.id("msgbox")).getText();
	    Assert.assertTrue(story7Detail.equals("List of all IMSIs with call failures during a given time period"));
	    
	    driver.findElement(By.id("support manager")).click();
	    System.out.println("support manager");
	    TimeUnit.SECONDS.sleep(3);
	    
	    driver.findElement(By.id("userStory8")).click();
	    System.out.println("story-8");
	    TimeUnit.SECONDS.sleep(3);
	    String story8Detail = driver.findElement(By.id("msgbox")).getText();
	    Assert.assertTrue(story8Detail.equals("Counts, for a given model of phone, the number of call failures it has had during a given time period."));

	    
	    driver.findElement(By.id("support manager")).click();
	    System.out.println("support manager");
	    TimeUnit.SECONDS.sleep(3);
	    
	    driver.findElement(By.id("userStory14")).click();
	    System.out.println("story-14");
	    TimeUnit.SECONDS.sleep(3);
	    String story14Detail = driver.findElement(By.id("msgbox")).getText();
	    Assert.assertTrue(story14Detail.equals("Display, for a given failure Cause Class, the IMSIs that were affected."));


	    driver.findElement(By.id("customer rep")).click();
	    System.out.println("customer rep");
	    TimeUnit.SECONDS.sleep(3);
	    
	    driver.findElement(By.id("userStory4")).click();
	    System.out.println("story-4");
	    TimeUnit.SECONDS.sleep(3);
	    String story4Detail = driver.findElement(By.id("msgbox")).getText();
	    Assert.assertTrue(story4Detail.equals("Display, for a given affected IMSI, the Event ID and Cause Code for any / all failures affecting that IMSI."));

	    
	    driver.findElement(By.id("customer rep")).click();
	    System.out.println("customer rep");
	    TimeUnit.SECONDS.sleep(3);
	    
	    driver.findElement(By.id("userStory5")).click();
	    System.out.println("story-5");
	    TimeUnit.SECONDS.sleep(3);
	    String story5Detail = driver.findElement(By.id("msgbox")).getText();
	    Assert.assertTrue(story5Detail.equals("Display, for a given IMSI, the number of failures during given time period."));

	    
	    driver.findElement(By.id("customer rep")).click();
	    System.out.println("customer rep");
	    TimeUnit.SECONDS.sleep(3);
	    
	    driver.findElement(By.id("userStory6")).click();
	    System.out.println("story-6");
	    TimeUnit.SECONDS.sleep(3);
	    String story6Detail = driver.findElement(By.id("msgbox")).getText();
	    Assert.assertTrue(story6Detail.equals("Display, for a given IMSI, all the unique Cause Codes associated with its call failures"));
	    
	    driver.findElement(By.id("logout")).click();
	    System.out.println("logout");
	    TimeUnit.SECONDS.sleep(3);
	    
	    driver.quit();
	    System.out.println("finally quit");
	    
	  }
}