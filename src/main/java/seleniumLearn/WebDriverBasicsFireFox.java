package seleniumLearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasicsFireFox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\hites\\Desktop\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//to launch URL
		driver.get("http://www.amazon.com");
		
		//get title of the page
		String title = driver.getTitle();
		
		//Expected title is : Amazon.com. Spend less. Smile more. 
		if(title.equals("Amazon.com. Spend less. Smile more.")){
			System.out.println("Test Case Passed - Title is as expected: " + title);
		}else {
			System.out.println("Test Case Failed - Title is not as expected" + title);
		}
		
		//Get current url browser is looking at
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);
		
		//close the browser
		//driver.quit();

	}

}
