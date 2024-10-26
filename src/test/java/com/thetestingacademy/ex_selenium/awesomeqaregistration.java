package com.thetestingacademy.ex_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class awesomeqaregistration {

    @Test
    public void awesomeqa(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get(" https://awesomeqa.com/ui/index.php?route=account/register");

        WebElement firstName= driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Sudip");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Mandal");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("sudip124@gmail.com");

        WebElement phonenumber = driver.findElement(By.id("input-telephone"));
        phonenumber.sendKeys("1234567");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("sa1234");

        WebElement confirmpassword = driver.findElement(By.id("input-confirm"));
        confirmpassword.sendKeys("sa1234");

        WebElement checkbox = driver.findElement(By.name("agree"));
        checkbox.click();

        WebElement submit= driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        submit.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(driver.getTitle(),"Your Account Has Been Created!");
        driver.quit();












    }

}
