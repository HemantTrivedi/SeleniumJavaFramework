package com.app.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.pages.LoginSignupModalPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {

  LoginSignupModalPage loginPage;

  @BeforeTest
  public void setup() throws InterruptedException {
    // Initialize LoginPage with driver
    loginPage = new LoginSignupModalPage(driver);
  }

  @Test
  void verifyUserLoginIsSuccessful() {
    loginPage.clickLogin();
    loginPage.login("test", "test");
    boolean isLoginSuccessful = loginPage.isUserNameDisplayed();
    assertThat(isLoginSuccessful).as("Check if the login is successful").isTrue();
  }
}
