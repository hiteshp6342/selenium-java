package seleniumLearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitalizeBrowser {

	WebDriver driver;
	//method to initilize the browser
		public WebDriver launchBrowser(String browserName) {

			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				System.out.println("Invalid browser");
			}

			return driver;
		}
		
		// initial browser settings
		public void setupBrower() {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
}
