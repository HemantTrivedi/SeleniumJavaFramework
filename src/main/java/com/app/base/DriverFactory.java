package com.app.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.app.utils.WebEventListenerUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	static WebDriver driver;

	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebDriverListener listener = new WebEventListenerUtil();
		WebDriver decoratedDriver = new EventFiringDecorator(listener).decorate(driver);
		return decoratedDriver;

	}

}
