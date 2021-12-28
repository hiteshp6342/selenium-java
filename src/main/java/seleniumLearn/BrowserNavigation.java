package seleniumLearn;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hites\\Desktop\\Drivers\\chromedriver.exe");
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
		
		//Longer way -- it doesn't let page load completely before performing actions
		driver.navigate().to("http://www.google.com");
		//print title of the page
		System.out.println(driver.getTitle());
		
		driver.navigate().back();//go back to amazon
		driver.navigate().forward();//go to google
		driver.navigate().back();//go to amazon again
		driver.navigate().refresh();

	}

}
