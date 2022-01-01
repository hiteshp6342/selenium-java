package seleniumLearn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagName {

	public static void main(String[] args) {
		
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		
		ElementActions actions = new ElementActions(driver);
		
		actions.launchUrl("http://automationpractice.com/index.php");
		
		
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		int totalLinks = listOfLinks.size();
		System.out.println("There are total " + totalLinks + " links");
		
		List<WebElement> listOfImages = driver.findElements(By.tagName("img"));
		int totalImages = listOfImages.size();
		System.out.println("There are total " + totalImages + " images");
		
		for(WebElement link:listOfLinks) {
			String linkText = link.getText();
			String href = link.getAttribute("href");
			
			if(!linkText.isBlank()) {
				//System.out.println(linkText);
				System.out.println(linkText + " ---> " + href);
			}
//			if(linkText.equals("Sign in")) {
//				link.click();
//				break;
//			}
			
		}
		


	}

}
