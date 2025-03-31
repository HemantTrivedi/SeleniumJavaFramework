package com.app.pages;

import com.app.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
  private WebDriver driver;
  private ElementActions elementActions;

  // Locators for header elements
  private By homeLink = By.xpath("//a[text()='Home']");
  private By contactLink = By.xpath("//a[text()='Contact']");
  private By aboutUsLink = By.xpath("//a[text()='About us']");
  private By loginLink = By.xpath("//a[text()='Log in']");
  private By signUpLink = By.id("signin2");
  private By cartLink = By.id("cartur");
  private By userName = By.id("nameofuser");

  // Constructor
  public HeaderPage(WebDriver driver) {
    this.driver = driver;
    this.elementActions = new ElementActions(driver);
  }

  // Click Methods using ElementActions
  public void clickHome() {
    elementActions.clickElement(homeLink);
  }

  public void clickContact() {
    elementActions.clickElement(contactLink);
  }

  public void clickAboutUs() {
    elementActions.clickElement(aboutUsLink);
  }

  public void clickLogin() {
    elementActions.clickElement(loginLink);
  }

  public void clickSignUp() {
    elementActions.clickElement(signUpLink);
  }

  public void clickCart() {
    elementActions.clickElement(cartLink);
  }

  // Get the text of the active page
  public String getCurrentPageTitle() {
    return driver.getTitle();
  }

  public boolean isUserNameDisplayed() {
    return elementActions.isElementDisplayed(userName);
  }
}
