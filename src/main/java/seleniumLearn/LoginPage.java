package seleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public static void main(String[] args) {
		
		//Locators
		By userName = By.id("username");
		By password = By.id("password");
		By loginButton = By.id("Login");
		By forgotPassword = By.linkText("Forgot Your Password?");

		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		ElementActions actions = new ElementActions(driver);
		
		initBrowser.setupBrower();		
		//to launch URL 
		actions.launchUrl("https://login.salesforce.com/");
		
		//using common methods to perform actions
		actions.doSendKeys(userName, "test@gmail.com");
		actions.doSendKeys(password, "test123");
		actions.doClick(loginButton);
		
//		actions.doActionsSendKeys(userName, "test@gmail.com");
//		actions.doActionsSendKeys(password, "test123");
//		actions.doActionsClick(loginButton);
	}
	
	
	

	

}
