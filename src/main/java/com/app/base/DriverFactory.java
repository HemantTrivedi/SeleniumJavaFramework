package com.app.base;

import com.app.utils.PropertyReader;
import com.app.utils.WebEventListenerUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class DriverFactory {

  static WebDriver driver;
  private static PropertyReader propertyReader;
  private static long pageLoadTimeout;

  static {
    propertyReader = new PropertyReader("src/main/resources/config.properties");
    pageLoadTimeout = Long.parseLong(propertyReader.getProperty("page.load.timeout"));
  }

  public static WebDriver getDriver() {
    String browser = propertyReader.getProperty("browser").toLowerCase();
    boolean isHeadless = Boolean.parseBoolean(propertyReader.getProperty("headless"));
    System.out.println(propertyReader.getProperty("headless"));
    switch (browser) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
          options.addArguments("--headless");
        }
        driver = new ChromeDriver(options);
        break;
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
      case "edge":
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        break;
      default:
        throw new IllegalArgumentException("Invalid browser name: " + browser);
    }

    WebDriverListener listener = new WebEventListenerUtil();
    WebDriver decoratedDriver = new EventFiringDecorator(listener).decorate(driver);
    return decoratedDriver;
  }

  public static WebDriver setUp() {
    WebDriver decoratedDriver = getDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
    return decoratedDriver;
  }

  public static void goToUrl(String url) {
    driver.get(url);
  }

  public static void quiteDriver() {
    driver.quit();
  }
}
