package seleniumLearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeBrowser {

	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hites\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//Fullscreen browser
		//driver.manage().window().fullscreen();
		
		//to launch URL
		driver.get("http://www.amazon.com");
						
		//get title of the page
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);


	}

}
