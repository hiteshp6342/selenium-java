package seleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hites\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		
		//to launch URL - Convenient way - it lets page load before performing actions
		driver.get("https://login.salesforce.com/");
		
		By userName = By.id("username");
		By password = By.id("password");
		By loginButton = By.id("Login");
		By forgotPassword = By.linkText("Forgot Your Password?");
		
		driver.findElement(userName).sendKeys("test");
		driver.findElement(password).sendKeys("test");
		driver.findElement(loginButton).click();
		Thread.sleep(5000);
		driver.findElement(forgotPassword).click();
	}

}
