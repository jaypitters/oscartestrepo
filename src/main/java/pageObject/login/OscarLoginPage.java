package pageObject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObject.OscarPage;
import pageObject.appt.OscarApptPage;

/**
 * page object representing the Oscar login page.
 */
public class OscarLoginPage extends OscarPage<OscarLoginPage> {

	/**
	 * @element pin This is the pin field of the login form
	 */
	@FindBy(name = "loginForm")
	WebElement loginForm;
	
	/**
	 * @element username This is the username field of the login form
	 */
	@FindBy(name = "username")
	WebElement usernameField;
	
	/**
	 * @element password This is the password field of the login form
	 */
	@FindBy(name = "password")
	WebElement passwordField;
	
	/**
	 * @element submit This is the sign-in button of the login form
	 */
	@FindBy(xpath = "/html/body/table[2]/tbody/tr/td/form/input[3]")
	WebElement submitButton;
	
	/**
	 * @element pin This is the pin field of the login form
	 */
	@FindBy(name = "pin")
	WebElement pinField;
	
	/**
	 * @element errorBox This is the error-message area of the login form
	 */
	//@FindBy(className = "leftbar")
	@FindBy(xpath = "/html/body/table/tbody/tr/td")
	WebElement errorBox;
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.titleContains("");
	}

	@Override
	protected String getPageUrl() {
		return "";
	}

	public OscarLoginPage open() {
		return new OscarLoginPage().openPage(OscarLoginPage.class);
	}
	
	public OscarApptPage goToApptPage() {
		return new OscarApptPage().openPage(OscarApptPage.class);
	}
	
	/*
	 * This action will log in to Oscar
	 */
	public void login(String login, String password, String pin){
		usernameField.sendKeys(login);
		passwordField.sendKeys(password);
		pinField.sendKeys(pin);
		submitButton.click();
	}
	
	public boolean isLoginError() {
		boolean isLoginError = false;
		if (errorBox.getText().contains("Incorrect")) {
			isLoginError = true;
		}
		return isLoginError;
	}
	
	public String getErrorMessage() {
		return errorBox.getText();
	}
	
	//this is a test comment. please disregard
	
}
