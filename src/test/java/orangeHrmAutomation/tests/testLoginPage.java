package orangeHrmAutomation.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import orangeHrmAutomation.libraries.Base;
import orangeHrmAutomation.libraries.ExcelManager;
import orangeHrmAutomation.pages.LoginPage;

public class testLoginPage extends Base {
	private String excelPath="src/test/resources/test-data/loginData.xlsx";
	
	@DataProvider(name = "loginPageTest")
	private Object[][] loginData(){
		Object[][] data=null;
		ExcelManager excel=new ExcelManager(excelPath, "logindata");
		data=excel.getExcelData();
		return data;
		
	}
	@Test(dataProvider = "loginPageTest")
	public void LoginPageTest(String UserName, String password) {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.gotoLoginPage();
		loginPage.goTODashBoard(UserName, password);
	

}
}