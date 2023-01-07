package orangeHrmAutomation.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import orangeHrmAutomation.libraries.Base;

public class RequitmentPage extends Base {

	private WebDriver driver;
	public RequitmentPage(WebDriver _driver) {
		this.driver=_driver;
	}
	public RequitmentPage requitmentMenu(String reqList) throws AWTException {
	
		WebElement reqment=driver.findElement(By.cssSelector("div.oxd-topbar-body > nav > ul"));
		List<WebElement >reqlist=reqment.findElements(By.tagName("li"));
		for(WebElement reqlists:reqlist) {
			System.out.println(reqlists.getText());
			if(reqList.contains("Candidate")) {
				reqlist.get(0).click();
				gotoCandidate();
			}
			else if(reqList.contains("Vacancies")) {
				reqlist.get(1).click();	
				gotoVacancy();
			}
			else {
				System.out.println("wrong entry");
			}
		}
		return this;
	
		
	
}
	public void gotoVacancy() {
		WebElement jobTitle=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > div > div > div.oxd-select-text-input"));
		try {
		jobTitle.click();
		}catch (StaleElementReferenceException e) {
			jobTitle=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > div > div > div.oxd-select-text-input"));
			jobTitle.click();
		}
		/*
		WebElement title=driver.findElement(By.cssSelector("div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > div > div.oxd-select-dropdown.--positon-bottom > div:nth-child(2) > span"));
		title.click();
	
		WebElement searchBtn=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		searchBtn.click();
		*/
	}
	public void gotoCandidate() throws AWTException{
		
		//candidate search
		WebElement jobTitle=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > div > div > div.oxd-select-text-input"));
		myLibGS.highlightWebElement(jobTitle);
		jobTitle.click();
	
		WebElement title=driver.findElement(By.cssSelector("div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > div > div.oxd-select-dropdown.--positon-bottom > div:nth-child(2) > span"));
		myLibGS.highlightWebElement(title);
		title.click();
			
		WebElement searchBtn=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		myLibGS.highlightWebElement(searchBtn);
		searchBtn.click();
		myLibGS.customWait(5);
		
		//add candidate
		WebElement addBtn=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-header-container > button"));
		myLibGS.highlightWebElement(addBtn);
		addBtn.click();
		
	
		
		WebElement firstname=driver.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(2) > input"));
		WebElement lastname=driver.findElement(By.cssSelector("div:nth-child(3) > div:nth-child(2) > input"));
		WebElement email=driver.findElement(By.cssSelector("div:nth-child(3) > div > div:nth-child(1) > div > div:nth-child(2) > input"));
		myLibGS.highlightWebElement(firstname);
		firstname.sendKeys("Joe");
		myLibGS.highlightWebElement(lastname);
		lastname.sendKeys("Swan");
		myLibGS.highlightWebElement(email);
		email.sendKeys("jswan@gmail.com");
		myLibGS.customWait(5);
		//upload resume file
		WebElement uploadfile=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > i"));
		myLibGS.highlightWebElement(uploadfile);
		uploadfile.click();
		String fileLocation="C:\\Users\\patha\\Desktop\\images\\resume.txt";
		StringSelection ss = new StringSelection(fileLocation);
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	     //imitate mouse events like ENTER, CTRL+C, CTRL+V
	     Robot robot;
		
		robot = new Robot();
		
	     myLibGS.customWait(3);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     myLibGS.customWait(3);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     
		myLibGS.customWait(5);
		

	     WebElement save=driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
	     myLibGS.highlightWebElement(save);
	   
	     save.click();
		
	     
	     
	
		}
	}
