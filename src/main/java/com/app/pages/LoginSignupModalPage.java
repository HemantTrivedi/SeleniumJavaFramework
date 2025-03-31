package com.app.pages;

import com.app.utils.ElementActions;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupModalPage extends HeaderPage {
  WebDriver driver;
  ElementActions elementActions;

  // Locators for Login elements
  private By usernameField = By.id("loginusername");
  private By passwordField = By.id("loginpassword");
  private By loginButton = By.xpath("//button[text()='Log in']");
  private By closeButton = By.xpath("//button[text()='Close']");

  // Locators for Sign up modal
  private By signUpUsername = By.id("sign-username");
  private By signUpPassword = By.id("sign-password");
  private By signUpSubmit = By.xpath("//button[text()='Sign up']");

  // Constructor
  public LoginSignupModalPage(WebDriver driver) {
    super(driver); // Calls the constructor of HeaderPage
    this.elementActions = new ElementActions(driver);
  }

  // Methods for Login Actions
  public void enterUsername(String username) {
    elementActions.enterText(usernameField, username);
  }

  public void enterPassword(String password) {
    elementActions.enterText(passwordField, password);
  }

  public void clickLoginButton() {
    elementActions.clickElement(loginButton);
  }

  public void closeLoginPopup() {
    elementActions.clickElement(closeButton);
  }

  // Perform full login process
  public void login(String username, String password) {
    enterUsername(username);
    enterPassword(password);
    clickLoginButton();
  }

  // Enter sign-up username
  public void enterSignUpUsername(String username) {
    elementActions.enterText(signUpUsername, username);
  }

  // Enter sign-up password
  public void enterSignUpPassword(String password) {
    elementActions.enterText(signUpPassword, password);
  }

  // Click sign-up button
  public void clickSignUpButton() {
    elementActions.clickElement(signUpSubmit);
  }

  // Method to perform sign-up
  public void signUp(String username, String password) {
    enterSignUpUsername(username);
    enterSignUpPassword(password);
    clickSignUpButton();
  }

  public String getSignUpAlertMessageAndAccept() {
    elementActions.waitUntilAlertIsDisplayed();
    String alertText = elementActions.getAlertTextAndCloseAlert();
    return alertText; // Return alert message for validation
  }

  public boolean isMessageDisplayed(String expectedText) {
    List<String> messagesText =
        elementActions.getElements(closeButton).stream()
            .map(e -> e.getText().trim())
            .toList(); // Java 16+ feature, or use .collect(Collectors.toList()) for Java 8
    return messagesText.contains(expectedText);
  }
}
