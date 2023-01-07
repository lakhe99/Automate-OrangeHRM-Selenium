package orangeHrmAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import orangeHrmAutomation.libraries.Base;

public class PIMPage extends Base{
	private WebDriver driver;
	public PIMPage(WebDriver _driver) {
		this.driver= _driver;

}
	public void selectAddUser() {
		WebElement pimMenuItm=driver.findElement(By.cssSelector("div.oxd-topbar-body > nav > ul"));
		List<WebElement>pimlist=pimMenuItm.findElements(By.tagName("li"));
		pimlist.get(2).click();
		WebElement addfirstname=driver.findElement(By.name("firstName"));
		addfirstname.sendKeys("John");
		
		WebElement addlasttname=driver.findElement(By.name("lastName"));
		addlasttname.sendKeys("Miller");
		WebElement addempId=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(1) > div.oxd-grid-2.orangehrm-full-width-grid > div > div > div:nth-child(2) > input"));
		addempId.sendKeys("1102");
		WebElement savebtn=driver.findElement(By.cssSelector("div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		savebtn.click();
		myLibGS.customWait(5);
		
		
		}
	public void checkEmployeeList() {
		WebElement pimMenuItm=driver.findElement(By.cssSelector("div.oxd-topbar-body > nav > ul"));
		List<WebElement>pimlist=pimMenuItm.findElements(By.tagName("li"));
		pimlist.get(1).click();
		WebElement empList=driver.findElement(By.cssSelector("div:nth-child(1) > div > div:nth-child(2) > div > div > input"));
		empList.sendKeys("R");
		WebElement searchbtn=driver.findElement(By.cssSelector("div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		searchbtn.click();
		myLibGS.customWait(5);
	}
	
		
		}
	
