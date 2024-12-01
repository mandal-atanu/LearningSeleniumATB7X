package com.thetestingacademy.ex_selenium.ex_27102024;

import com.thetestingacademy.ex_selenium.OrangeDemo;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.thetestingacademy.ex_selenium.OrangeDemo.wait;

public class svg_p2 {
    ChromeDriver driver;





    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //ptions.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Description("Verify that the tripura is in india and click on it.")
    @Test
    public void test_svg_india_search_click()  {

        driver.manage().window().maximize();
        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement india = driver.findElement(By.xpath("//*[local-name()='svg']/*[local-name()='g']"));
        js.executeScript("arguments[0].scrollIntoView(true);",india);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // local-name() , name()- Xpath (built in)
        // document.querySelectorAll("#login-username"); - JS
        List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='svg']/*[local-name()='g'][7]/*[local-name()='g']/*[local-name()='g']/*[local-name()='path']"));
        for(WebElement state:states){
            System.out.println(state.getAttribute("aria-label"));
            if(state.getAttribute("aria-label").contains("Tripura")){
                state.click();

            }
        }





    }
//
//    @AfterTest
//    public void closeBrowser() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        driver.quit();
//    }


}
