package com.app.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.pages.LoginSignupModalPage;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {

  private Faker faker;
  private String randomUsername;
  private String randomPassword;
  LoginSignupModalPage loginPage;

  @BeforeClass(alwaysRun = true)
  public void setup() throws InterruptedException {
    loginPage = new LoginSignupModalPage(driver);
    faker = new Faker();
  }

  @BeforeMethod(alwaysRun = true)
  public void generateTestData() {
    randomUsername = faker.name().username();
    randomPassword = faker.internet().password();
  }

  @Test(
      groups = {"Smoke"},
      description = "Verify user can successfully sign up")
  public void testSignUp() {
    loginPage.clickSignUp();
    loginPage.signUp(randomUsername, randomPassword);
    String successText = loginPage.getSignUpAlertMessageAndAccept();
    assertThat(successText)
        .as("Checking if the actual text matches the expected text")
        .isEqualTo("Sign up successful.");
  }
}
