package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Selenium driver wrapper
 * 
 * @author McMaster Family Med
 * @author mlipski
 */

public class seleniumDriver {
	
	static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new FirefoxDriver(); // can be replaced with HtmlUnitDriver for better performance
		}
		return driver;
	}
}
