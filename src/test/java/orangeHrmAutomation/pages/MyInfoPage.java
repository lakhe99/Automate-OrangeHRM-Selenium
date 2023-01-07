package orangeHrmAutomation.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import orangeHrmAutomation.libraries.Base;

public class MyInfoPage extends Base {
	String fileLocation="C:\\Users\\patha\\Desktop\\images\\download.jpg";
	private WebDriver driver;
	public MyInfoPage(WebDriver _driver) {
		this.driver=_driver;
		
	}
	public void changeProfilePicture() {
		try {
		WebElement profilepicture=driver.findElement(By.cssSelector("div.orangehrm-edit-employee-image-wrapper > div > img"));
		profilepicture.click();
		
		WebElement prochange=driver.findElement(By.cssSelector("div:nth-child(2) > div > button > i"));
		prochange.click();
		StringSelection ss = new StringSelection(fileLocation);
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	     //imitate mouse events like ENTER, CTRL+C, CTRL+V
	     Robot robot = new Robot();
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     
	     WebElement save=driver.findElement(By.cssSelector("div.orangehrm-edit-employee-content > div > form > div.oxd-form-actions > button"));
	     save.click();
	     
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
	