package seleniumLearn;

import org.openqa.selenium.WebDriver;

public class AuthenticationPopUp {

	public static void main(String[] args) {
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		System.out.println(driver.getTitle());
		
	}

}
