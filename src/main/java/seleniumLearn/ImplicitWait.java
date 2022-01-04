package seleniumLearn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		initBrowser.setupBrower();
		//global wait applied to all elements being used in the browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ElementActions myActions = new ElementActions(driver);
		
		//to launch URL 
		myActions.launchUrl("https://www.easemytrip.com/");

		By from = By.id("FromSector_show");
		By to = By.id("Editbox13_show");
		By searchButton = By.className("src_btn");
		By bookNow = By.xpath("(//button[text() = 'Book Now'])[1]");
		
		
		myActions.doSendKeys(from, "Kolkata");
		myActions.doSendKeys(to, "Bangalore");
		
		myActions.doClick(searchButton);
		
		myActions.doClick(bookNow);//no such element: Unable to locate element -- without wait
		
		
		

	}

}
