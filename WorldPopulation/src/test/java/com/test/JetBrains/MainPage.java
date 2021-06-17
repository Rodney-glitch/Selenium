package com.test.JetBrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//header/div[1]/div[1]/a[2]/*[1]")
    public WebElement seeAllToolsButton;

    @FindBy(xpath = "//div[contains(text(),'Developer Tools')]")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test=menu-main-icon-search]")
    public WebElement searchButton;

    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
}
