package seleniumLearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSessionID {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hites\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//to launch URL
		driver.get("http://www.amazon.com");
		
		//get title of the page
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);
		
		//driver.quit();
		//System.out.println(driver.getTitle());//Session ID is null. Using WebDriver after calling quit()?
		
		driver.close();//Session id is kept but browser is closed
		System.out.println(driver.getTitle());//org.openqa.selenium.NoSuchSessionException: invalid session id
		
		
	}

}
