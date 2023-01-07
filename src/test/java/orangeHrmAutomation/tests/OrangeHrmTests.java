
package orangeHrmAutomation.tests;

import org.testng.annotations.Test;


import orangeHrmAutomation.libraries.Base;
import orangeHrmAutomation.libraries.JavaPropertiesManager;
import orangeHrmAutomation.pages.AdminPage;
import orangeHrmAutomation.pages.DashboardPage;
import orangeHrmAutomation.pages.LeavePage;
import orangeHrmAutomation.pages.LoginPage;
import orangeHrmAutomation.pages.MyInfoPage;
import orangeHrmAutomation.pages.PIMPage;
import orangeHrmAutomation.pages.TimePage;

public class OrangeHrmTests extends Base {
	private String filePath="src/test/resources/config.properties";
	JavaPropertiesManager propManager=new JavaPropertiesManager(filePath);
	String userName=propManager.readProperty("username");
	String passWord=propManager.readProperty("password");

	
	@Test(priority = 0)
	public void LoginPageTest() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.gotoLoginPage();
		loginPage.goTODashBoard(userName, passWord);
		
	}
	@Test(priority = 1)
	public void dodashBoardPageTest() {
		LoginPageTest();
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.gotoAdminPage();
		dashboardPage.gotoPIMPage();
		dashboardPage.gotoLeavePage();
		dashboardPage.gotoTimePage();
		dashboardPage.gotoRequitementPage();
		dashboardPage.gotoMyInfoPage();
		}
	@Test(priority = 2)
	public void adminPageTest() {
		LoginPageTest();
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.gotoAdminPage();
		AdminPage admnpage=new AdminPage(driver);
		admnpage.clickNationality();
		
	
}
	@Test(priority = 3)
	public void PIMPageTest() {
		LoginPageTest();
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.gotoPIMPage();
		PIMPage pim=new PIMPage(driver);
		pim.selectAddUser();
		pim.checkEmployeeList();
		
	}
	@Test(priority = 4)
	public void leavePageTest() {
		LoginPageTest();
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.gotoLeavePage();
		LeavePage leave=new LeavePage(driver);
		leave.applyLeave();
	}
	@Test(priority = 5)
	public void timePageTest() {
		LoginPageTest();
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.gotoTimePage();
		TimePage timePage=new TimePage(driver);
		timePage.gotoTimeSheet();
		
	}
//	@Test(priority = 5)
//	public void requitmentPageTest(){
//		LoginPageTest();
//		DashboardPage dashboardPage=new DashboardPage(driver);
//		dashboardPage.gotoRequitementPage();
//		RequitmentPage reqPage=new RequitmentPage(driver);
//		try {
//			reqPage.requitmentMenu("Vacancies");
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
	@Test(priority = 5)
	public void myInfoPageTest() {
		LoginPageTest();
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.gotoMyInfoPage();
		MyInfoPage myinfo=new MyInfoPage(driver);
		//myinfo.personalDetail();
		myinfo.changeProfilePicture();
		
	}
	

}
