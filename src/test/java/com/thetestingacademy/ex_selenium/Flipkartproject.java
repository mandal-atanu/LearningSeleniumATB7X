package com.thetestingacademy.ex_selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Flipkartproject {

    @Description("Verify that the after search, results are visible.")
    @Test
    public void test_flipkart(){

        WebDriver drive = new ChromeDriver();
        drive.get("https://www.flipkart.com");
        drive.manage().window().maximize();

        WebElement searchbox = drive.findElement(By.name("q"));
        searchbox.sendKeys("Iphone 15 pro max");
        searchbox.submit();

        List<WebElement> titiles = drive.findElements(By.xpath("//div[contains(@data-id,'MOB')]/div/a/div[2]/div[1]/div[1]"));

        for (WebElement title : titiles){
            System.out.println(title.getText());
            if (title.getText().contains("(White Titanium, 512 GB)")){
                title.click();
            }


        }



    }



}
