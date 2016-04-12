package selenium_testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class sample {
		
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setup() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/TheBeanQuartet";
	}

	@Test
	public void testFileImportTime() throws Exception {
		driver.get(baseUrl);
		
		// log in as System Admin
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("Ivan");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.name("Login")).click();
		
		System.out.println("Logged in as Network Management Engineer");
		
		driver.findElement(By.linkText("Network Management Engineer")).click();
		System.out.println("Clicked Network Management Engineer");

		String temp="Count, for each IMSI, number of call failures and duration during a time period";
		//select.selectByVisibleText(temp);
		//select.selectByIndex(1);
		driver.findElement(By.linkText(temp)).click();
		System.out.println("Clicked on "+temp);
		
		driver.get(baseUrl+"/userStoryNineCountEachImsi.html");
		assertTrue(driver.findElement(By.id("myTable")).isDisplayed());
		System.out.println("Table is not empty");

		// start timer and press upload button
		long start = System.currentTimeMillis();
		driver.findElement(By.id("submit")).click();
		System.out.println("Submit");
		List<WebElement> listA=driver.findElements(By.tagName("td"));
		assertFalse(listA.isEmpty());
		long end = System.currentTimeMillis();
		float duration = end-start;
		
		// ensure time is within tolerance
		System.out.println("Time taken for upload: "+duration+" milliseconds");
		int twoSecond = (1000*2);
		
		System.out.print("Asserting that: "+duration+" is less than: "+twoSecond+"....  ");
		System.out.println((duration < twoSecond));
		
		assertTrue(duration < twoSecond);
		
	}
	
}
