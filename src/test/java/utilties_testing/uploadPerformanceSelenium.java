package utilties_testing;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class uploadPerformanceSelenium {
	
	private static final String FILE_PATH = "/home/tommy/Documents/Group Project - Dataset 3A 2016.xls";
	
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
		driver.findElement(By.id("username")).sendKeys("Thomas");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.name("Login")).click();
		
		System.out.println("Logged in as System Admin");
		
		// move to upload page and enter data set file
		driver.findElement(By.id("upload")).click();
		driver.get(baseUrl+"/uploadXLS.html");
		driver.findElement(By.id("formInput")).sendKeys(FILE_PATH);
		
		// start timer and press upload button
		long start = System.currentTimeMillis();
		driver.findElement(By.id("uploadButton")).click();
		Alert alert = checkAlert();
		long end = System.currentTimeMillis();
		float duration = end-start;
		
		// ensure time is within tolerance
		System.out.println("Time taken for upload: "+duration+" milliseconds");
		int twoMinsMillis = (1000*60*2);
		
		System.out.print("Asserting that: "+duration+" is less than: "+twoMinsMillis+"....  ");
		System.out.println((duration < twoMinsMillis));
		
		assertTrue(duration < twoMinsMillis);
		
		alert.accept();
	}
	
	private Alert checkAlert() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        if(alert.getText().contains("File upload complete")) {
	        	System.out.println("Found file complete alert");
	        	System.out.println("Alert text = "+alert.getText());
	        } else {
	        	System.out.println("Did not observe file complete alert");
	        	System.out.println("Alert text = "+alert.getText());
	        }
	        return alert;
	    } catch (Exception e) {
	        System.out.println("No alert!");
	        return null;
	    } 
	}
}
