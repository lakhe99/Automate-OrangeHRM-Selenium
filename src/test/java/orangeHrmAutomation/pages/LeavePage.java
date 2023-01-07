package orangeHrmAutomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import orangeHrmAutomation.libraries.Base;

public class LeavePage extends Base {
	private WebDriver driver;

	public LeavePage(WebDriver _driver) {
		this.driver = _driver;

	}

	public LeavePage gotoLeavePage() {
		WebElement leaveMenu = driver.findElement(By.cssSelector("ul > li:nth-child(3) > a"));
		leaveMenu.click();
		return new LeavePage(driver);
	}

	public void applyLeave() {
		WebElement leaveMenuItm = driver.findElement(By.cssSelector("div.oxd-topbar-body > nav > ul"));
		List<WebElement> leavelist = leaveMenuItm.findElements(By.tagName("li"));
		leavelist.get(0).click();
		String message="No Leave Types with Leave Balance";
		if(message.contains(message)) {
			System.out.println("no further implementation");
			
		}else {
			
		
		
		WebElement leaveType = driver.findElement(By.cssSelector("div.oxd-select-text--after"));
		leaveType.click();
		myLibGS.customWait(2);
		WebElement leaveItem = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > div > div.oxd-select-dropdown.--positon-bottom > div:nth-child(2) > span"));
		myLibGS.highlightWebElement(leaveItem);
		leaveItem.click();
		
		
		

		myLibGS.customWait(2);

		WebElement fromDate = driver.findElement(By.cssSelector(
				"#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(2) > div > div:nth-child(1) > div > div:nth-child(2) > div > div > input"));
		//fromDate.click();
		fromDate.clear();
		fromDate.sendKeys("2023-01-05");
		myLibGS.customWait(5);
		WebElement toDate=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(2) > div > div:nth-child(2) > div > div:nth-child(2) > div > div > input"));
		toDate.sendKeys(Keys.CONTROL + "a");
		toDate.sendKeys(Keys.DELETE);
		toDate.sendKeys("2023-01-10");

		myLibGS.customWait(5);
		WebElement leaveComment = driver.findElement(By.cssSelector("div:nth-child(2) > textarea"));
		leaveComment.sendKeys("Please approve leave ASAP");

		myLibGS.customWait(10);

		WebElement applyButton = driver.findElement(By.cssSelector("div.oxd-form-actions > button"));
		applyButton.click();
		}
	}

}
