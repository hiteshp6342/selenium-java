package seleniumLearn;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		ElementActions myActions = new ElementActions(driver);
		
		//to launch URL 
		myActions.launchUrl("https://demoqa.com/browser-windows");
		
		By newWindowButton = By.id("windowButton");
		By childHeading = By.id("sampleHeading");
		
		String parentWindow = driver.getWindowHandle();

		myActions.doClick(newWindowButton);
		
		System.out.println("Parent Window: " + parentWindow);
		switchToChildWindow(driver);
		String childPageHeader = myActions.getElementText(childHeading);
		System.out.println(childPageHeader);
		driver.close();
		switchToParentWindow(driver, parentWindow);
		System.out.println(driver.getTitle());
			
		myActions.doClick(newWindowButton);
		switchToChildWindow(driver);
		childPageHeader = myActions.getElementText(childHeading);
		System.out.println(childPageHeader);
		driver.close();
		switchToParentWindow(driver, parentWindow);
		System.out.println(driver.getTitle());

	}
	
	public static void switchToChildWindow(WebDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> wh = windowHandles.iterator();
		wh.next();
		String childWindow = wh.next();
		System.out.println(childWindow);
		driver.switchTo().window(childWindow);
	}
	
	public static void switchToParentWindow(WebDriver driver, String parentWindow) {
		driver.switchTo().window(parentWindow);
	}

}
