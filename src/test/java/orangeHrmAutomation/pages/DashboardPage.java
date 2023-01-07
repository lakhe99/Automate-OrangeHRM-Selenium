package orangeHrmAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import orangeHrmAutomation.libraries.Base;
import orangeHrmAutomation.libraries.JavaPropertiesManager;

public class DashboardPage extends Base{
	
	private WebDriver driver;
	public DashboardPage(WebDriver _driver) {
		this.driver=_driver;
		
	}
	public AdminPage gotoAdminPage() {
		
		WebElement adminBtn=driver.findElement(By.cssSelector("ul > li:nth-child(1) > a"));
		adminBtn.click();
		return new AdminPage(driver);
	
	
	}
	public PIMPage gotoPIMPage() {
		WebElement pimMenu=driver.findElement(By.cssSelector("ul > li:nth-child(2) > a"));
		pimMenu.click();
		return new PIMPage(driver);
		
	}
	public LeavePage gotoLeavePage() {
		WebElement leaveMenu=driver.findElement(By.cssSelector("ul > li:nth-child(3) > a"));
		leaveMenu.click();
		return new LeavePage(driver);
	}
	public TimePage gotoTimePage() {
		WebElement timeMenu=driver.findElement(By.cssSelector("ul > li:nth-child(4) > a"));
		timeMenu.click();
		return new TimePage(driver);
		
	}
	public TimePage gotoRequitementPage() {
		WebElement reqMenu=driver.findElement(By.cssSelector("ul > li:nth-child(5) > a"));
		reqMenu.click();
		return new TimePage(driver);
	
		
	}
	
	public MyInfoPage gotoMyInfoPage() {
		WebElement myinfoMenu=driver.findElement(By.cssSelector("ul > li:nth-child(6) > a"));
		
		myinfoMenu.click();
		return new MyInfoPage(driver);	
}
	
		
}
	


