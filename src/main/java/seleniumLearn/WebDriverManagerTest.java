package seleniumLearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hites\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		
		//to launch URL - Convenient way - it lets page load before performing actions
		driver.get("http://www.amazon.com");
						
		//get title of the page
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);
	}

}
