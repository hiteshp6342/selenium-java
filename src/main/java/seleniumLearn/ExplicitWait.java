package seleniumLearn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		initBrowser.setupBrower();
		
		WebDriverWait wait = new WebDriverWait(driver,15);
	
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
		
		//wait for the element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(bookNow));
		
		myActions.doClick(bookNow);//no such element: Unable to locate element -- without wait
		

	}

}
