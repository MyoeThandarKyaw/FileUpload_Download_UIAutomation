package File.Upload_Download;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class uploadMultipleFile {
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

		//upload multiple photos
		for (int i = 1; i <= 5; i++) {
			WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
			switch (i) {
			case 1:

				addFile.sendKeys("D:\\MYOE\\Painting\\louts.jpeg");
				driver.findElement(By.xpath(".//span[text()='Start upload']")).click();
				break;
			case 2:

				addFile.sendKeys("D:\\MYOE\\Painting\\bagan.png");
				driver.findElement(By.xpath(".//span[text()='Start upload']")).click();
				break;
			case 3:

				addFile.sendKeys("D:\\MYOE\\Painting\\village.jpeg");
				driver.findElement(By.xpath(".//span[text()='Start upload']")).click();
				break;
				
			case 4:

				addFile.sendKeys("D:\\MYOE\\Painting\\field.jpeg");
				driver.findElement(By.xpath(".//span[text()='Start upload']")).click();
				break;
				
			case 5:

				addFile.sendKeys("D:\\MYOE\\Painting\\balloom.jfif");
				driver.findElement(By.xpath(".//span[text()='Start upload']")).click();
				break;

			}

		}

		Thread.sleep(2000);
		
		//check image upload
		for (int i = 1; i <= 3; i++) {
			switch (i) {
			case 1:

				if (driver.findElement(By.xpath(".//a[text()='louts.jpeg']")).isDisplayed()) {
					assertTrue(true, "Image Uploaded");
				} else {
					assertTrue(false, "Image not Uploaded");
				}
				break;
			case 2:

				if (driver.findElement(By.xpath(".//a[text()='bagan.png']")).isDisplayed()) {
					assertTrue(true, "Image Uploaded");
				} else {
					assertTrue(false, "Image not Uploaded");
				}
				break;
			case 3:

				if (driver.findElement(By.xpath(".//a[text()='village.jpeg']")).isDisplayed()) {
					assertTrue(true, "Image Uploaded");
				} else {
					assertTrue(false, "Image not Uploaded");
				}
				break;

			case 4:

				if (driver.findElement(By.xpath(".//a[text()='field.jpeg']")).isDisplayed()) {
					assertTrue(true, "Image Uploaded");
				} else {
					assertTrue(false, "Image not Uploaded");
				}
				break;
				
			case 5:

				if (driver.findElement(By.xpath(".//a[text()='balloom.jfif']")).isDisplayed()) {
					assertTrue(true, "Image Uploaded");
				} else {
					assertTrue(false, "Image not Uploaded");
				}
				break;
			}

		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"fileupload\"]/div/div[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"fileupload\"]/div/div[1]/button[3]/span")).click();
		
	}

	@AfterMethod
	public void afterMethod() throws Exception{
		Thread.sleep(2000);
		 driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
