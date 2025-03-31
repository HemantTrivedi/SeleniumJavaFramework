package com.app.utils;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
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
    int timeoutInSeconds = Integer.parseInt(propertyReader.getProperty("default.wait.time"));
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

  // Generic method to find an element
  public WebElement getElement(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  // Generic method to find multiple elements
  public List<WebElement> getElements(By locator) {
    return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
  }

  public WebElement waitForElementToVisible(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public WebElement waitForElementToBeClickable(By locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  public void clickElement(By locator) {
    WebElement element = getElement(locator);
    element.click();
  }

  public void enterText(By locator, String text) {
    WebElement element = getElement(locator);
    element.clear();
    element.sendKeys(text);
  }

  public String getElementText(By locator) {
    return getElement(locator).getText();
  }

  public boolean isElementDisplayed(By locator) {
    try {
      return getElement(locator).isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  public void waitUntilAlertIsDisplayed() {
    wait.until(ExpectedConditions.alertIsPresent()); // Wait for alert
  }

  public String getAlertTextAndCloseAlert() {
    Alert alert = driver.switchTo().alert(); // Switch to alert
    String alertText = alert.getText(); // Capture alert text
    alert.accept(); // Click OK to close the alert
    return alertText;
  }
}
