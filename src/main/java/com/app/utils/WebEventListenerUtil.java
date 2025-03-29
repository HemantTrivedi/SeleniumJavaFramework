package com.app.utils;

/*************************************** PURPOSE **********************************
 *
 * - This class implements the WebDriverEventListener, which is included under events.
 * The purpose of implementing this interface is to override all the methods and define certain useful  Log statements
 * which would be displayed/logged as the application under test is being run.
 *
 * Do not call any of these methods, instead these methods will be invoked automatically
 * as an when the action done (click, findBy etc).
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebEventListenerUtil implements WebDriverListener {

  @Override
  public void beforeFindElement(WebDriver driver, By locator) {
    System.out.println("Finding element: " + locator.toString());
  }

  @Override
  public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    System.out.println("Element found: " + locator.toString());
  }

  @Override
  public void beforeClick(WebElement element) {
    System.out.println("Attempting to click element: " + element.toString());
  }

  @Override
  public void afterClick(WebElement element) {
    System.out.println("Clicked element: " + element.toString());
  }

  @Override
  public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
    System.out.println(
        "Sending keys: " + String.join("", keysToSend) + " to element: " + element.toString());
  }

  @Override
  public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
    System.out.println(
        "Sent keys: " + String.join("", keysToSend) + " to element: " + element.toString());
  }

  public void beforeNavigateTo(String url, WebDriver driver) {
    System.out.println("Navigating to: " + url);
  }

  public void afterNavigateTo(String url, WebDriver driver) {
    System.out.println("Navigated to: " + url);
  }

  public void beforeNavigateBack(WebDriver driver) {
    System.out.println("Navigating back");
  }

  public void afterNavigateBack(WebDriver driver) {
    System.out.println("Navigated back");
  }

  public void beforeNavigateForward(WebDriver driver) {
    System.out.println("Navigating forward");
  }

  public void afterNavigateForward(WebDriver driver) {
    System.out.println("Navigated forward");
  }

  @Override
  public void beforeQuit(WebDriver driver) {
    System.out.println("Closing browser");
  }

  @Override
  public void afterQuit(WebDriver driver) {
    System.out.println("Browser closed");
  }
}
