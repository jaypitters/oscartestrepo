package pageObject;

import static setup.seleniumDriver.getDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pageObject.appt.*;

public abstract class OscarPage<T> {

	private static final String BASE_URL="http://localhost:8083/oscar";
	private static final int LOAD_TIMEOUT = 30;
	private static final int REFRESH_RATE = 2;
	
	public T openPage(Class<T> clazz) {
		T page = PageFactory.initElements(getDriver(), clazz);
		getDriver().get(BASE_URL + getPageUrl());
		ExpectedCondition pageLoadCondition = ((OscarPage) page).getPageLoadCondition();
		waitForPageToLoad(pageLoadCondition);
		return page;
	}
	
	private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
		Wait wait = new FluentWait(getDriver()).
				withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS).
				pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);
		
		wait.until(pageLoadCondition);
	}
	
	/**
	 * Provides Condition that determines when page is considered fully loaded.
	 * @return
	 */
	protected abstract ExpectedCondition getPageLoadCondition();
	
	/**
	 * Provides page relative URL/
	 * 
	 * @return
	 */
	protected abstract String getPageUrl();

	public static void logoutAnywhere() {
		// this method will disrupt any activity,
		// navigate to the appointment screen, and log out
		
		// this is temporary, we will need to clear all open windows
		new OscarApptPage().openPage(OscarApptPage.class).logout();
	}
	
	}
