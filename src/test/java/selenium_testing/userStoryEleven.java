package selenium_testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class userStoryEleven {
		
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setup() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/TheBeanQuartet";
	}

	@Test
	public void testQueryTime() throws Exception {		

		driver.get(baseUrl);
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("Ivan");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.name("Login")).click();
		
		System.out.println("Logged in as Network Management Engineer");
		
		driver.findElement(By.linkText("Network Management Engineer")).click();
		System.out.println("Clicked Network Management Engineer");

		String temp="Show top 10 Market/Operator/Cell ID combinations with call failures during a time period";
		//select.selectByVisibleText(temp);
		//select.selectByIndex(1);
		driver.findElement(By.linkText(temp)).click();
		System.out.println("Clicked on "+temp);
		
		driver.get(baseUrl+"/userStoryElevenTopTenMarketOperatorCell_ID.html");
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.id("myTable")).isDisplayed());
		System.out.println("Table is not empty");
		driver.findElement(By.id("select2")).sendKeys("0");
		String date="01/01/2013 1:30 PM - 30/01/2013 2:00 PM";
		driver.findElement(By.id("daterange")).sendKeys(date);
		driver.findElement(By.id("applyBtn")).click();
		//driver.findElement(By.className("range_inputs").linkText("Apply")).click();;

		long start = System.currentTimeMillis();
		driver.findElement(By.id("submit")).submit();
		System.out.println("Submit");
//		assertFalse(driver.findElements(By.tagName("td")).isEmpty());
//		WebElement web =driver.findElements(By.tagName("td")).get(0);
//		assertFalse(web.getText()!="");
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
