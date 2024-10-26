package com.thetestingacademy.ex_selenium.ex_19102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium008 {

    @Description("Verify that the error message will come for the wrong email at the free trail in the app.vwo.com signup page.")
    @Test
    public void test_error_free_trail(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://vwo.com/free-trial/");
        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("987656789dasdasd");

        WebElement checkbox = driver.findElement(By.id("page-878cu-gdpr-consent-checkbox"));
        checkbox.click();

        WebElement submit_button = driver.findElement(By.className("btn-modal-form-submit"));
        submit_button.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement invalid_reason = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(invalid_reason.getText(),"The email address you entered is incorrect.");
        System.out.println(invalid_reason.getText());




    }
}
