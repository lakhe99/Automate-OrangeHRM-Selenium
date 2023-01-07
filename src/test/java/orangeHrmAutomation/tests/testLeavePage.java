package orangeHrmAutomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import orangeHrmAutomation.libraries.Base;
import orangeHrmAutomation.pages.LeavePage;
import orangeHrmAutomation.pages.LoginPage;

public class testLeavePage extends Base {
	@Test(priority = 0)
	public void LoginPageTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.gotoLoginPage();
		loginPage.goTODashBoard(null, null);
		LeavePage leave=new LeavePage(driver);
		leave.gotoLeavePage();
		leave.applyLeave();
	}
	
}