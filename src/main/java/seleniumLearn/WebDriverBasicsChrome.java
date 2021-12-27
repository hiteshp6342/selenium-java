package seleniumLearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasicsChrome {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hites\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
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
		driver.quit();
	}

}
