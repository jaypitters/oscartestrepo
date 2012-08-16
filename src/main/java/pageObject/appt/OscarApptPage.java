package pageObject.appt;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObject.OscarPage;


public class OscarApptPage extends OscarPage<OscarApptPage> {

	/**
	 * @element logoutLink This is the logout link of the appointment page
	 */
	@FindBy(xpath = "/html/body/table/tbody/tr/td[2]/a[3]")
	public WebElement logoutLink;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.titleContains("");
	}

	@Override
	protected String getPageUrl() {
		return "/provider/providercontrol.jsp";
	}
	
	/*
	 * This method will log out the current session
	 */
	public void logout(){
		logoutLink.click();
	}
}
