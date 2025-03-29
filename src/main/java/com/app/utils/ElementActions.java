package com.app.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
  private WebDriver driver;
  private WebDriverWait wait;
  private static Duration defaultTimeout;
  private static PropertyReader propertyReader;

  static {
    propertyReader = new PropertyReader("src/main/resources/config.properties");
    int timeoutInSeconds = Integer.parseInt(propertyReader.getProperty("default.wait.time", "10"));
    defaultTimeout = Duration.ofSeconds(timeoutInSeconds);
  }

  public ElementActions(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public WebElement waitForElement(By locator, Duration timeout) {
    Duration finalTimeout = (timeout != null) ? timeout : defaultTimeout;
    WebDriverWait wait = new WebDriverWait(driver, finalTimeout);
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public WebElement findElement(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public void clickElement(By locator) {
    WebElement element = findElement(locator);
    element.click();
  }

  public void enterText(By locator, String text) {
    WebElement element = findElement(locator);
    element.clear();
    element.sendKeys(text);
  }

  public String getElementText(By locator) {
    return findElement(locator).getText();
  }

  public boolean isElementDisplayed(By locator) {
    try {
      return findElement(locator).isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
