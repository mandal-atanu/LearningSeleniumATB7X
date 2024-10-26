package com.thetestingacademy.ex_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APPVWOLOGIN01 {


    @Test
    public void APPVWOlogin(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://app.vwo.com/#/login");

        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("7x@wingify.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Wingify@4321");

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement dashboard = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        System.out.println(dashboard.getText());
        Assert.assertEquals(dashboard.getText(),"Dashboard");


        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




        WebElement usermenu = driver.findElement(By.xpath("//img[@data-qa= \"user-image\"]"));
        usermenu.click();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement logout = driver.findElement(By.xpath("//li[@data-qa = \"logout-btn\"]"));
        logout.click();



    }
}
