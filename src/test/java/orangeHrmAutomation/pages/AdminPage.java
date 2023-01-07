package orangeHrmAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import orangeHrmAutomation.libraries.Base;

public class AdminPage extends Base {
	private WebDriver driver;
	public AdminPage(WebDriver _driver) {
		this.driver= _driver;
		
	}
	
	public AdminPage clickNationality() {
		WebElement adminUl=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-body > nav > ul"));
		System.out.println(adminUl.getText());
		List<WebElement> lists=adminUl.findElements(By.tagName("li"));
		lists.get(4).click();

		myLibGS.customWait(5);
		WebElement addBtn=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div.orangehrm-header-container > div > button"));
		addBtn.click();
		
		WebElement addNationality=driver.findElement(By.cssSelector("div > div:nth-child(2) > input"));
		addNationality.sendKeys("Albania");
		
		WebElement saveBtn=driver.findElement(By.cssSelector(" div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		saveBtn.click();
		return this;
	}

}
