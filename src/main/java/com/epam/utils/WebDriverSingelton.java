package com.epam.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.epam.properties.Property;

public class WebDriverSingelton {

	private static WebDriver driver;
	private static Property prop = Property.getInstance();

	private WebDriverSingelton() {

	}

	public static WebDriver getInstance() {
		if (driver == null) {
			System.setProperty(prop.getPropertiesValue("driver"), prop.getPropertiesValue("driverPath"));
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			goToURL(prop.getPropertiesValue("url"));
		}
		return driver;
	}

	public static void goToURL(String url) {
		getInstance().navigate().to(url);
	}
}
