package com.app.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.pages.LoginSignupModalPage;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {

  private Faker faker;
  private String randomUsername;
  private String randomPassword;
  LoginSignupModalPage loginPage;

  @BeforeTest
  public void setup() throws InterruptedException {
    // Initialize LoginPage with driver
    loginPage = new LoginSignupModalPage(driver);
    faker = new Faker();
  }

  @BeforeMethod
  public void generateTestData() {
    randomUsername = faker.name().username();
    randomPassword = faker.internet().password();
  }

  @Test(description = "Verify user can successfully sign up")
  public void testSignUp() {
    loginPage.clickSignUp();
    loginPage.signUp(randomUsername, randomPassword);
    String successText = loginPage.getSignUpAlertMessageAndAccept();
    assertThat(successText)
        .as("Checking if the actual text matches the expected text")
        .isEqualTo("Sign up successful.");
  }
}
