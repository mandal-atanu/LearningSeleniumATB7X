package com.thetestingacademy.ex_selenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeDemo {

	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;

	@BeforeClass
	public void setUp() throws InterruptedException {
		// Setup WebDriver
		driver = new ChromeDriver();

		// Open the Orange HRM login page
		driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

		// Maximize the browser window
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		js = (JavascriptExecutor) driver;
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		
		WebElement uname = driver.findElement(By.xpath("//input[@name='username']"));
		uname.sendKeys("Admin");

		// Locate and enter the password
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys("Hacker@4321");

		WebElement loginBtn = driver.findElement(By.xpath("//button[text()=' Login ']"));
		loginBtn.click();

		Thread.sleep(3000);
	}

	@Test(priority = 2, description = "Terminate first terminated employee")
	public void terminateEmployee() throws IOException {
		// Scroll to the table containing the employee data to ensure visibility
		WebElement table = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']"));
		js.executeScript("arguments[0].scrollIntoView(true);", table);

		List<WebElement> employeeRows = driver.findElements(By.xpath(
				"//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']"));

		System.out.println(employeeRows.size());

		// Loop through the rows to find the first "Terminated" employee
		for (WebElement row : employeeRows) {
			// Get the Employment Status cell
			WebElement employmentStatusCell = row.findElement(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable' and @role='row']/div[@class='oxd-table-cell oxd-padding-cell' and @role='cell'][6]"));
			String employmentStatus = employmentStatusCell.getText().trim();

			System.out.println(employmentStatus);

			// Check if the employment status is "Terminated"
			if (employmentStatus.equalsIgnoreCase("Terminated")) {
				// Click the delete button on this row
				WebElement deleteButton = row.findElement(By
						.xpath(".//div[contains(@class, 'oxd-table-cell')][9]//button/i[@class='oxd-icon bi-trash']"));

				deleteButton.click();
				//takeScreenShot();
				break; // Exit the loop after finding the first terminated employee
			}
		}
	}

//	public void takeScreenShot() throws IOException {
//		// Create a timestamp for the screenshot file name
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
//		String timestamp = formatter.format(new Date());
//
//		String fileName = "orangeUser";
//		// Take screenshot
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//
//		File dest = new File(System.getProperty("user.dir") + "\\orange\\" + fileName + "_" + timestamp + ".png");
//
//		// Copy the screenshot from source to destination
//		FileUtils.copyFile(src, dest);
//
//		System.out.println("Screenshot saved: " + dest.getAbsolutePath());
//	}
}
