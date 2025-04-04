package com.app.tests;

import com.app.base.DriverFactory;
import com.app.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

  protected WebDriver driver; // Protected allows access in child classes
  private static PropertyReader propertyReader;
  String url;

  @BeforeClass(alwaysRun = true)
  public void customSetup() throws InterruptedException {

    propertyReader = new PropertyReader("src/main/resources/config.properties");
    url = propertyReader.getProperty("base.url");
    driver = DriverFactory.setUp();
    DriverFactory.goToUrl(url);
  }

  @AfterClass(alwaysRun = true)
  void tearDown() {
    DriverFactory.quiteDriver();
  }
}
