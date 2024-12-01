package com.thetestingacademy.ex_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OrangeHRM {
    WebDriver driver;
    Wait wait;
    JavascriptExecutor js;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--start-maximized");

        driver = new EdgeDriver(edgeOptions);
        driver.manage().deleteAllCookies();

    }


    @Test(priority = 1)
    public void login() {
        String url = "https://awesomeqa.com/hr/web/index.php/auth/login";
        driver.get(url);

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));


        WebElement inputBox = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordBox = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("oxd-button"));

        inputBox.sendKeys("admin");
        passwordBox.sendKeys("Hacker@4321");
        loginBtn.click();
        System.out.println("test 1");

    }

    @Test(priority = 2)
    public void checkingTerminate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-container']")));

//        WebElement container = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));
//        js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", container);

        By row_element = By.xpath("(//div[@class='oxd-table-card']/div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'])");

        List<WebElement> row_size = driver.findElements(row_element);
        int col = driver.findElements(By.xpath("(//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable' and @role='row'])[1]/div[@class='oxd-table-cell oxd-padding-cell']")).size();
        int row = row_size.size();
//  terminate text -       //div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable' and @role='row']/div[@class='oxd-table-cell oxd-padding-cell' and @role='cell'][6]

        System.out.println(row);
        System.out.println(col);


        for (int i = 1; i <= row; i++) {
            String delete_btn_path = "((//div[@class='oxd-table-card']/div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'])[" + i + "]/div[9]/div[@class='oxd-table-cell-actions']/button[@class='oxd-icon-button oxd-table-cell-action-space']/i[@class='oxd-icon bi-trash'])";
            WebElement click_terminate = driver.findElement(By.xpath(delete_btn_path));

            String terminate_path = "(//div[@class='oxd-table-card']/div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'])[" + i + "]/div[6]";
            WebElement terminate = driver.findElement(By.xpath(terminate_path));

            if (!terminate.getText().isEmpty()) {


//                js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(delete_btn_path)));
                Assert.assertTrue(click_terminate.isDisplayed());
                System.out.println(terminate.getText());
                click_terminate.click();

                driver.findElement(By.xpath("//div[@class='oxd-dialog-container-default']/div/div/div[3]/button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']")).click();
//                break;
            }

        }
    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

}


//     (//div[@class='oxd-table-card']/div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'])[1]/div[9]/div[@class='oxd-table-cell-actions']/button[@class='oxd-icon-button oxd-table-cell-action-space']