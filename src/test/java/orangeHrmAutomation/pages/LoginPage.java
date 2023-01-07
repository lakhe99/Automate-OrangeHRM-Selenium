package orangeHrmAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import orangeHrmAutomation.libraries.Base;

public class LoginPage extends Base {
	String webUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	private WebDriver driver;
	
	public LoginPage(WebDriver _driver) {
		this.driver=_driver;
	}
	
	public LoginPage gotoLoginPage() {
		driver.get(webUrl);
		return this;
	
	}
	public DashboardPage goTODashBoard(String username, String password) {
		
		WebElement userName=driver.findElement(By.name("username"));
		userName.sendKeys(username);
		//myLibGS.enterText(By.name("username"), username);
		WebElement passWord=driver.findElement(By.name("password"));
		passWord.sendKeys(password);
		//myLibGS.enterText(By.name("password"), password);
		WebElement loginBtn=driver.findElement(By.cssSelector("div.oxd-form-actions.orangehrm-login-action"));
		loginBtn.click();
		myLibGS.customWait(5);
		
		return new DashboardPage(driver);
		
	}

	
	

}
