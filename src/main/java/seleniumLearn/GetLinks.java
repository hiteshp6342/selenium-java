package seleniumLearn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetLinks {

	public static void main(String[] args) {


		
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		
		ElementActions actions = new ElementActions(driver);
		
		actions.launchUrl("http://automationpractice.com/index.php");
		
		By footerLinks = By.xpath("//*[@id='block_various_links_footer']/ul/li/a");
		actions.verifyLinks(footerLinks);
		
//		for(int i = 0; i<footerLinks.size();i++) {
//			System.out.println(footerLinks.get(i).getText());
//			footerLinks.get(i).click();//stale element reference: element is not attached to the page document -- clicking link refreshes the dom
//			driver.navigate().back(); //going back doesn't fix the problem
//			footerLinks = driver.findElements(By.xpath("//*[@id='block_various_links_footer']/ul/li/a"));
//		}
		
	}

}
