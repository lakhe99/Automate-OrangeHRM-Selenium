package orangeHrmAutomation.libraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class JavaPropertiesManager {

	private String propertiesFile;
	private Properties prop;
	private FileInputStream input;
	private FileOutputStream output;

	public JavaPropertiesManager(String propertiesFilePath) {
		try {
			if (propertiesFilePath.length() > 0) {
				propertiesFile = propertiesFilePath;
				prop = new Properties();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readProperty(String key) {
		String value = null;
		try {
			input = new FileInputStream(propertiesFile);
			prop.load(input);
			value = prop.getProperty(key);
			System.out.println("Reading properties file ---> " + propertiesFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public void setProperty(String key, String value) {
		try {
			output = new FileOutputStream(propertiesFile);
			prop.setProperty(key, value);
			prop.store(output, null);
			System.out.println("Properties file is updated/created. ---> " + propertiesFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this is main method used only for testing this class
	/*
	 * public static void main(String[] args) { try {
	 * 
	 * String filePath = "src/test/resources/config.properties";
	 * JavaPropertiesManager propManager = new JavaPropertiesManager(filePath); //
	 * update or creating java properties file propManager.setProperty("browser",
	 * "Chrome"); propManager.setProperty("demoMode", "Off"); Thread.sleep(2 *
	 * 1000);
	 * 
	 * // reading existing java properties file for property key & value String key
	 * = "demoMode"; String propertyValue = propManager.readProperty(key);
	 * System.out.println("key:" + key + ", value: " + propertyValue);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

}
