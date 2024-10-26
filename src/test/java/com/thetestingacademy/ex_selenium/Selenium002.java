package com.thetestingacademy.ex_selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium002 {

    @Test
    public void testmethod(){

//        EdgeOptions edgeOptions = new EdgeOptions();
//        edgeOptions.addArguments("--start-maximized");
//        //edgeOptions.addArguments("--window-size=800,600");
//
//        EdgeDriver driver = new EdgeDriver();
//        driver.get("https://google.com");
//        driver.quit();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://google.com");
        //chromeDriver.manage().window().maximize();

    }
}
