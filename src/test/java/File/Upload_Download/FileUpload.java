package File.Upload_Download;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.assertTrue;

public class FileUpload {
	WebDriver driver;

	@BeforeClass
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		// Instantiate a ChromeDriver class.
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		// Maximize the browser
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	}

	@Test
	public void testFileUpload() throws Exception {
		WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
		
		addFile.sendKeys("D:\\MYOE\\Painting\\bagan.png");

		driver.findElement(By.xpath(".//span[text()='Start upload']")).click();
		
		Thread.sleep(2000);
//		String text=driver.findElement(By.xpath("//*[@id=\"fileupload\"]/table/tbody/tr/td[2]/p/a")).getText();
//		System.out.println("Text "+text);
//		
//		Assert.assertEquals("bagan.png", text);
//		
		if(driver.findElement(By.xpath(".//a[text()='bagan.png']")).isDisplayed()) {
			assertTrue(true, "Image Uploaded");
		}else {
			assertTrue(false, "Image not Uploaded");
		}
		
		driver.findElement(By.xpath("//*[@id=\"fileupload\"]/table/tbody/tr/td[4]/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"fileupload\"]/table/tbody/tr/td[4]/button/i")).click();
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
