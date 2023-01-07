package orangeHrmAutomation.tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmGridTest {
	private WebDriver driver;
	private String HubUrl="http://192.168.137.1:4444";
 
@Test
public void gridTest() {
	try {
	ChromeOptions chromeOptions=new ChromeOptions();
	DesiredCapabilities caps=new DesiredCapabilities();
	caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	System.out.println("Starting remote selenium chrome driver ....");
	
		driver=new RemoteWebDriver(URI.create(HubUrl).toURL(),caps);
		driver.get("https://www.google.com/");
		System.out.println("website is: "+driver.getTitle());
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
@Test
public void gridTest2() throws MalformedURLException {
	try {
	WebDriverManager.chromedriver().setup();
	ChromeOptions chromeOps=new ChromeOptions();
	chromeOps.setCapability("browserName", "chrome");
	chromeOps.setCapability("platformName", "Window");
	chromeOps.setCapability("se:name", "test name");
	chromeOps.setCapability("se:sampleMetadata", "Sample metadata value");
	
	WebDriver driver=new RemoteWebDriver(new URL(HubUrl), chromeOps);
	driver.get("https://www.google.com/");
	System.out.println(driver.getTitle());
	Thread.sleep(20*1000);
	driver.quit();
	
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}


}


