package com.tugas.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginSauceDemoTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void tcLogin004_usernameAndPasswordEmpty_shouldShowUsernameRequiredError() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualText = errorMessage.getText();
        String expectedText = "Epic sadface: Username is required";

        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void tcLogin005_onlyUsernameFilled_shouldShowPasswordRequiredError() {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys("standard_user");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualText = errorMessage.getText();
        String expectedText = "Epic sadface: Password is required";

        Assert.assertEquals(actualText, expectedText);
    }
}

