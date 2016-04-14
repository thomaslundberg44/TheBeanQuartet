package selenium_testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class userStorySix {
		
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setup() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/TheBeanQuartet";
	}

	@Test
	public void testQueryTime() throws Exception {		

		String imsi="344930000000011";
		driver.get(baseUrl);
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("Ivan");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.name("Login")).click();
		
		System.out.println("Logged in as Network Management Engineer");
		
		driver.findElement(By.linkText("Customer Service Representative")).click();
		System.out.println("Clicked Customer Service Representative");

		String temp="For affected IMSI, show the Event ID and Cause Code";

		driver.findElement(By.linkText(temp)).click();
		System.out.println("Clicked on "+temp);
		
		driver.get(baseUrl+"/userStorySixGetCauseCodeAndFailureForAnImsi.html");
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.id("myTable")).isDisplayed());
		System.out.println("Table is not empty");
		driver.findElement(By.id("select2")).sendKeys(imsi);
		System.out.println(imsi+" passed in");
		// start timer and press upload button
		long start = System.currentTimeMillis();
		
		driver.findElement(By.id("submit")).submit();
		System.out.println("Submit");
		//List<WebElement> listA=driver.findElements(By.tagName("td"));
//		WebElement web =driver.findElements(By.tagName("td")).get(0);
//		assertFalse(web.getText()=="");
		assertFalse(driver.findElements(By.tagName("td")).isEmpty());
		long end = System.currentTimeMillis();
		float duration = end-start;

		// ensure time is within tolerance
		System.out.println("Time taken for upload: "+duration+" milliseconds");
		int twoSecond = (1000*2);
		
		System.out.print("Asserting that: "+duration+" is less than: "+twoSecond+"....  ");
		System.out.println((duration < twoSecond));
		
		assertTrue(duration < twoSecond);
		driver.close();
		
	}
	
}
