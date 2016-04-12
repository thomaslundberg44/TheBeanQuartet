package selenium_testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class userStoryEight {
		
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setup() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/TheBeanQuartet";
	}

	@Test
	public void testQueryTime() throws Exception {		

		String model="VEA3";
		driver.get(baseUrl);
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("Ivan");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.name("Login")).click();
		
		System.out.println("Logged in as Network Management Engineer");
		
		driver.findElement(By.linkText("Support Engineer")).click();
		System.out.println("Clicked Support Engineer");

		String temp="Model of phone, count call failures during a time period";

		driver.findElement(By.linkText(temp)).click();
		System.out.println("Clicked on "+temp);
		
		driver.get(baseUrl+"/userStoryEightSearchByPhoneModel.html");
		System.out.println("111111111");
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.id("myTable")).isDisplayed());
		System.out.println("Table is not empty");
		driver.findElement(By.id("select2")).sendKeys(model);
		System.out.println(model+" passed in");
		String date="01/01/2013 1:30 PM - 30/01/2013 2:00 PM";
		driver.findElement(By.id("daterange")).sendKeys(date);
		driver.findElement(By.id("applyBtn")).click();
		// start timer and press upload button
		long start = System.currentTimeMillis();
		
		driver.findElement(By.id("submit")).submit();
		System.out.println("Submit");
		//List<WebElement> listA=driver.findElements(By.tagName("td"));
//		WebElement web =driver.findElements(By.tagName("td")).get(0);
//		assertFalse(web.getText()=="");
		long end = System.currentTimeMillis();
		float duration = end-start;
		assertFalse(driver.findElements(By.tagName("td")).isEmpty());

		// ensure time is within tolerance
		System.out.println("Time taken for upload: "+duration+" milliseconds");
		int twoSecond = (1000*2);
		
		System.out.print("Asserting that: "+duration+" is less than: "+twoSecond+"....  ");
		System.out.println((duration < twoSecond));
		
		assertTrue(duration < twoSecond);
		driver.close();
	}
	
}
