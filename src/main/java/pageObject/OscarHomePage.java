package pageObject;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OscarHomePage extends OscarPage<OscarHomePage>{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.titleContains("");
	}

	@Override
	public String getPageUrl() {
		return "";
	}

	public OscarLoginPage goToLoginPage() {
		return new OscarLoginPage().openPage(OscarLoginPage.class);
	}

	public OscarHomePage open() {
		return new OscarHomePage().openPage(OscarHomePage.class);
	}
	
}
