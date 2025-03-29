package com.app.tests;

import com.app.base.DriverFactory;
import com.app.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogIntest {

  private WebDriver driver;
  private ElementActions elementActions;

  @BeforeTest
  public void setup() {

    driver = DriverFactory.getDriver();
    driver.manage().window().maximize();
    // Initialize ElementActions
    elementActions = new ElementActions(driver);
  }

  @Test
  void checkTheUrl() {

    driver.get("https://www.google.com");

    By textBox = By.name("q");
    
    
    elementActions.enterText(textBox, "Selenium 4 WebDriver");
    WebElement searchBox =     driver.findElement(textBox); // Find the element
    searchBox.submit();
  }

  @AfterTest
  void tearDown() {
    driver.quit();
  }
}
