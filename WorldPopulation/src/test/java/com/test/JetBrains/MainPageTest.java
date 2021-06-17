package com.test.JetBrains;

import com.test.DriverFactory.chrome;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        driver = chrome.open();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.jetbrains.com/");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        mainPage.searchButton.click();

        WebElement searchField = driver.findElement(By.tagName("input"));
        searchField.sendKeys("Selenium");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement searchPageField = driver.findElement(By.xpath("//h2[contains(text(),\"What's New in IntelliJ IDEA - 2020.2\")]"));
        assertEquals(searchPageField.getText(), "What's New in IntelliJ IDEA - 2020.2");
        searchPageField.click();
    }

    @Test
    public void toolsMenu() {
        new Actions(driver)
                .moveToElement(mainPage.toolsMenu)
                .perform();

        WebElement menuPopup = driver.findElement(By.xpath("//p[contains(text(),'AppCode')]"));
        assertTrue(menuPopup.isDisplayed());
        menuPopup.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Ignore
    public void navigationToAllTools() {
        mainPage.seeAllToolsButton.click();

        WebElement productsList = driver.findElement(By.className("products-list"));
        assertTrue(productsList.isDisplayed());
        assertEquals(driver.getTitle(), "All Developer Tools and Products by JetBrains");
    }
}
