package seleniumLearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest {
	
	static WebDriver driver;

	public static void main(String[] args) {

		String browserName = "safari";

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hites\\Desktop\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\hites\\Desktop\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\hites\\Desktop\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser");
		}

		// to launch URL
		driver.get("http://www.amazon.com");

		// get title of the page
		String title = driver.getTitle();

		// Expected title is : Amazon.com. Spend less. Smile more.
		if (title.equals("Amazon.com. Spend less. Smile more.")) {
			System.out.println("Test Case Passed - Title is as expected: " + title);
		} else {
			System.out.println("Test Case Failed - Title is not as expected" + title);
		}

		// Get current url browser is looking at
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);

		// close the browser
		driver.quit();
	}

}
