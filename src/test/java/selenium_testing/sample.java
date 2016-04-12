package selenium_testing;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		// move to upload page and enter data set file
		//driver.findElement(By.id("Network Management Engineer")).click();
		//driver.get(baseUrl+"/userStoryFive.html");
	//	driver.findElement(By.id("formInput")).sendKeys(FILE_PATH);
		//Select select = new Select(driver.findElement(By.className("dropdown-menu")));
		//Select select = new Select(driver.findElement(By.linkText("").click());
		driver.findElement(By.linkText("Network Management Engineer")).click();
		System.out.println("!!!!!!!!!!!!!!!!!!");
		//select.deselectAll();
	

		String temp="Count, for each IMSI, number of call failures and duration during a time period";
		//select.selectByVisibleText(temp);
		//select.selectByIndex(1);
		driver.findElement(By.linkText(temp)).click();
		System.out.println("!!!!!!!!!!!!!!!!!!");
		
		//driver.findElement(By.id("button")).submit();;
		driver.get(baseUrl+"/userStoryNineCountEachImsi.html");
		driver.findElement(By.id("submit")).click();
		//driver.findElement(By.cssSelector("input[type='submit']"));
		System.out.println("!!!!!!!!!!!!!!!!!!");
		// start timer and press upload button
//		long start = System.currentTimeMillis();
//		driver.findElement(By.id("uploadButton")).click();
		//driver.findElement(By.name("submit"));
		//System.out.println("!!!!!!!!!!!!!!!!!!");

//		Alert alert = checkAlert();
//		long end = System.currentTimeMillis();
//		float duration = end-start;
//		
//		// ensure time is within tolerance
//		System.out.println("Time taken for upload: "+duration+" milliseconds");
//		int twoMinsMillis = (1000*60*2);
//		
//		System.out.print("Asserting that: "+duration+" is less than: "+twoMinsMillis+"....  ");
//		System.out.println((duration < twoMinsMillis));
//		
//		assertTrue(duration < twoMinsMillis);
//		
//		alert.accept();
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
