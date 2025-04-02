package com.app.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.pages.LoginSignupModalPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {

  LoginSignupModalPage loginPage;

  @BeforeClass(alwaysRun = true)
  public void setup() throws InterruptedException {
    loginPage = new LoginSignupModalPage(driver);
  }

  @Test(
      groups = {"Smoke"},
      description = "Verify user can successfully Log in in app")
  void verifyUserLoginIsSuccessful() {
    loginPage.clickLogin();
    loginPage.login("test", "test");
    boolean isLoginSuccessful = loginPage.isUserNameDisplayed();
    assertThat(isLoginSuccessful).as("Check if the login is successful").isTrue();
  }
}
