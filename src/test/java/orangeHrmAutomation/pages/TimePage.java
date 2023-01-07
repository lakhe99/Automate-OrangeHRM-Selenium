package orangeHrmAutomation.pages;

import java.util.Iterator;
import java.util.List;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import orangeHrmAutomation.libraries.Base;

public class TimePage extends Base {
	private WebDriver driver;

	public TimePage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void gotoTimeSheet() {
		try {
		Actions act1 = new Actions(driver);
		WebElement timeSheetMenu = driver.findElement(By.cssSelector("div.oxd-topbar-body > nav > ul"));
		List<WebElement> timeList = timeSheetMenu.findElements(By.tagName("li"));
		timeList.get(0).click();
		myLibGS.customWait(5);
		WebElement mytimeSheets = driver.findElement(By.className("oxd-topbar-body-nav-tab-link"));
		act1.moveToElement(mytimeSheets).click().perform();
		myLibGS.customWait(5);
		
		
		

		// to select the date for timesheet
		WebElement sheetWeek = driver.findElement(By.cssSelector("div > button.oxd-icon-button.orangehrm-timeperiod-icon.--prev"));
		act1.click(sheetWeek).click().build().perform();
		
		WebElement edit=driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--ghost"));
		act1.click(edit).build().perform();
					
		
		
		
		
		WebElement hints=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > form > div.orangehrm-timesheet-body > table > tbody > tr:nth-child(1) > td:nth-child(1) > div > div:nth-child(2) > div > div > input"));
		myLibGS.highlightWebElement(hints);
		hints.sendKeys(Keys.CONTROL + "a");
		hints.sendKeys(Keys.DELETE);
		hints.sendKeys("AC");
		myLibGS.customWait(5);
		WebElement selecthints=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > form > div.orangehrm-timesheet-body > table > tbody > tr:nth-child(1) > td:nth-child(1) > div > div:nth-child(2) > div > div.oxd-autocomplete-dropdown.--positon-bottom > div:nth-child(1) > span"));
		myLibGS.highlightWebElement(selecthints);
		
		selecthints.click();
		
		myLibGS.customWait(2);
		
		
		WebElement activity=driver.findElement(By.cssSelector("div.orangehrm-timesheet-body > table > tbody > tr:nth-child(1) > td:nth-child(2) > div"));
		activity.click();
		myLibGS.customWait(2);
		WebElement chooseActivity=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > form > div.orangehrm-timesheet-body > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div:nth-child(2) > div > div.oxd-select-dropdown.--positon-bottom > div:nth-child(3) > span"));
		chooseActivity.click();
		
		
		myLibGS.customWait(5);
		
		WebElement monday=driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(3) > div > div:nth-child(2) > input"));
		WebElement tuesday=driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(4) > div > div:nth-child(2) > input"));
		WebElement wednesday=driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(5) > div > div:nth-child(2) > input"));
		WebElement thursday=driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(6) > div > div:nth-child(2) > input"));
		WebElement friday=driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(7) > div > div:nth-child(2) > input"));
		WebElement saturday=driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(8) > div > div:nth-child(2) > input"));
		WebElement sunday=driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(9) > div > div:nth-child(2) > input"));
				
		monday.sendKeys("8:00");
		tuesday.sendKeys("8:00");
		wednesday.sendKeys("8:00");
		thursday.sendKeys("8:00");
		friday.sendKeys("8:00");
		saturday.sendKeys("0:00");
		sunday.sendKeys("0:00");		
		WebElement saveBtn=driver.findElement(By.cssSelector("div.orangehrm-timesheet-footer--options > button.oxd-button.oxd-button--medium.oxd-button--secondary"));
		act1.click(saveBtn).build().perform();
		}
		catch (StaleElementReferenceException e) {
			e.printStackTrace();
		
		}
		
		
	}

}
