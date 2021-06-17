package com.test.WorldPopulation;

import com.sun.istack.internal.NotNull;
import com.test.DriverFactory.chrome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestAutomation {

    WebDriver driver;
    PageObject pageObject;

    @BeforeTest
    public void setup(){
        driver = chrome.open();
        driver.manage().window().maximize();

        driver.get("https://www.worldometers.info/world-population/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        pageObject = new PageObject(driver);
    }

    @AfterTest
    public void exit(){
        driver.quit();
    }

    @Test
    public void run() throws InterruptedException {
        int i = 1;
        while (i<=10){
            System.out.println(i + "sec(s)");
            System.out.println("=========Total Population=========");
            printPopulation(pageObject.totalPopulation);
            System.out.println("Births Today | Deaths Today | Population Today |");
            printPopulation(pageObject.today);
            System.out.println("====Births this Year====");
            printPopulation(pageObject.birthYear);
            System.out.println("====Deaths this Year====");
            printPopulation(pageObject.deathYear);
            System.out.println("====Population this Year====");
            printPopulation(pageObject.popYear);
            System.out.println("=====================================================================================");
            Thread.sleep(1000);
            i++;
        }

    }


    public void printPopulation(@NotNull List<WebElement> element){
        for (WebElement e : element){
            System.out.print(" [ "+e.getText()+" ] ");
        }
        System.out.println("\n");
    }

}
