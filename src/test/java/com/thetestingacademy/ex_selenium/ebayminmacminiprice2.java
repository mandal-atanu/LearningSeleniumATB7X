package com.thetestingacademy.ex_selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class ebayminmacminiprice2 {

    @Description("Verify that Ebay Print the Prices")
    @Test
    public void ebay_Verify_Prices() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.ebay.com/");

        //<input type="text" class="gh-tb ui-autocomplete-input" aria-autocomplete="list" aria-expanded="true" size="50"
        // maxlength="300" aria-label="Search for anything" placeholder="Search for anything"
        // id="gh-ac" name="_nkw" autocapitalize="off" autocorrect="off" spellcheck="false" autocomplete="off" aria-haspopup="true" role="combobox" aria-owns="ui-id-1">


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //<input type="text" class="gh-tb ui-autocomplete-input" aria-autocomplete="list" aria-expanded="true" size="50"
        // maxlength="300" aria-label="Search for anything" placeholder="Search for anything"
        // id="gh-ac" name="_nkw" autocapitalize="off" autocorrect="off" spellcheck="false" autocomplete="off" aria-haspopup="true" role="combobox" aria-owns="ui-id-1">

        WebElement search_box = driver.findElement(By.id("gh-ac"));
        search_box.sendKeys("macmini");

        //<input type="submit" class="btn btn-prim gh-spr" id="gh-btn"
        // value="Search" form="gh-f">
        WebElement btnclick = driver.findElement(By.id("gh-btn"));
        btnclick.click();

        //<span role="heading" aria-level="3"> <div class="s-item__title"><span role="heading" aria-level="3"><!--F#f_0-->Apple 2018 Mac Mini 3GHz 6 Core i5 8GB RAM 512GB SSD 1 YEAR WARRANTY- Excellent<!--F/--></span></div>
        // <!--F#f_0-->Apple 2018 Mac Mini 3GHz 6 Core i5 8GB RAM 512GB SSD 1 YEAR WARRANTY- Excellent<!--F/--></span>

        List<WebElement> searchtitiles = driver.findElements(By.xpath("//span[@role = \"heading\"]"));
        List<WebElement> searchprices = driver.findElements(By.xpath("//span[@class='s-item__price']"));

        int size = Math.min(searchtitiles.size(), searchprices.size());

        double minPrice = Double.MAX_VALUE;
        System.out.println("Mac Mini Listings:");

        for (int i = 0; i < size; i++)
        {


            String title = searchtitiles.get(i).getText();
            String priceText = searchprices.get(i).getText();

            System.out.println("Title: " + title + "||" + "Price: " + priceText);
            System.out.println();

            // Parse the price and check for minimum

//            double price = Double.parseDouble(priceText);
//            if (price < minPrice) {
//                minPrice = price;
//            }

            if (isNumeric(priceText)) {
                double price = Double.parseDouble(priceText);
                if (price < minPrice) {
                    minPrice = price;
                }
                System.out.println("Title: " + title);
                System.out.println("Price: $" + price);
            } else {
                System.out.println("Non-numeric price ignored: " + priceText);
            }






        }

        if (minPrice == Double.MAX_VALUE) {
            System.out.println("No valid price found for minimum calculation.");
        } else {
            System.out.println("Minimum Price: $" + minPrice);
        }

//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }



    }
}
