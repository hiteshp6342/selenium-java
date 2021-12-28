package seleniumLearn;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCookies {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hites\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		
		//Fullscreen browser
		//driver.manage().window().fullscreen();
		
		//Get all available cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies);
		
		//to launch URL
		driver.get("http://www.amazon.com");
						
		//get title of the page
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);

		

	}

}
