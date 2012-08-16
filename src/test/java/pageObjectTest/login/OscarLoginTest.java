package pageObjectTest.login;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static setup.seleniumDriver.getDriver;


import org.junit.AfterClass;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;

import pageObject.OscarHomePage;
import pageObject.OscarLoginPage;
import pageObject.OscarPage;

public class OscarLoginTest {
	
	@AfterClass
	public void tearDownAfterClass()
	{
		// close the current selenium driver and all opened driver windows 
		getDriver().close();
	}
	
	@After
	public void tearDown() {
		// logout and close driver
		try {		
			OscarPage.logoutAnywhere();
		} catch (Exception e){
			// this will only be reached if the login attempt was a failure
			System.out.println("Login failed: " + e);
		}
	}
	
	
	@Test
	public void ValidLoginTest() {
		// login using valid login info
		String username = "drw";
		String password = "mac2002";
		String pin = "1117";
		OscarLoginPage loginPage = new OscarHomePage().open().goToLoginPage();
		loginPage.login(username, password, pin);
		//then
		assertFalse(loginPage.isLoginError());
	}
	
	
	@Test
	/*
	 * NOTE: Cannot run 3 or more failure tests consecutively because the user will be locked out.
	 */
	public void InvalidPasswordTest() {
		
		// invalid password
		String username = "drw";
		String password = "";
		String pin = "1117";
		
		// given
		OscarLoginPage loginPage = new OscarHomePage().open().goToLoginPage();
		loginPage.login(username, password, pin);
				
		// then
		assertTrue(loginPage.isLoginError());
	}
		
	
	@Test
	public void InvalidUsernameTest() {
		
		// invalid password
		String username = "foo";
		String password = "mac2002";
		String pin = "1117";
		
		// given
		OscarLoginPage loginPage = new OscarHomePage().open().goToLoginPage();
		loginPage.login(username, password, pin);
		
		// then
		assertTrue(loginPage.isLoginError());
	}
	
}
