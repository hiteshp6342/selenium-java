package seleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumLocators {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hites\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		
		//to launch URL - Convenient way - it lets page load before performing actions
		driver.get("https://login.salesforce.com/");
		
		//id
		//driver.findElement(By.id("username")).sendKeys("salesforceqa@gmail.com");
		//driver.findElement(By.id("password")).sendKeys("testqa");
		//driver.findElement(By.id("Login")).click();
		 
		//name
		//driver.findElement(By.name("username")).sendKeys("salesforceqa@gmail.com");
		//driver.findElement(By.name("pw")).sendKeys("testqa");
		//driver.findElement(By.name("Login")).click();

		//className
		//driver.findElement(By.className("username")).sendKeys("salesforceqa@gmail.com");
		//driver.findElement(By.className("password")).sendKeys("testqa");

		//linkText
		//driver.findElement(By.linkText("Forgot Your Password?")).click();
	
		//partialLinkText
		//driver.findElement(By.partialLinkText("Forgot")).click();
		
		//cssSelector
		//driver.findElement(By.cssSelector("#username")).sendKeys("salesforceqa@gmail.com");
		//driver.findElement(By.cssSelector("#password")).sendKeys("testqa");
		//driver.findElement(By.cssSelector("#Login")).click();

		//xPath
		WebElement userName = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='Login']"));
		
		userName.sendKeys("salesforceqa@gmail.com");
		password.sendKeys("testQA");
		loginButton.click();
		
		//tagName
		
		
	}

}
