package com.test.WorldPopulation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PageObject {

    @FindBy(xpath = "//*[@class='maincounter-number']//span[@rel='current_population']")
    List<WebElement> totalPopulation;

    @FindBy(xpath = "//div[text()='Today']//parent::div//span[contains(@class, 'rts-counter')]")
    List<WebElement> today;

    @FindBy(xpath = "//div[@class='col2in']//span[@rel='births_this_year']")
    List<WebElement> birthYear;

    @FindBy(xpath = "//div[@class='col2in']//span[@rel='dth1s_this_year']")
    List<WebElement> deathYear;

    @FindBy(xpath = "//div[@class='col2in']//span[@rel='absolute_growth_year']")
    List<WebElement> popYear;

    public PageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
