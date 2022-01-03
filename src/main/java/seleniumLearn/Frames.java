package seleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frames {

	public static void main(String[] args) {
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		ElementActions myActions = new ElementActions(driver);
		
		//to launch URL 
		myActions.launchUrl("https://demoqa.com/nestedframes");

		//switch by frame id or name
		//driver.switchTo().frame("frame2");
		
		//switch by web element
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='frame1']")));
		
		//switch by index
		//driver.switchTo().frame(2);
		
		myActions.switchToFrame("frame1");
		WebElement sampleHeading = driver.findElement(By.xpath("/html/body"));
		System.out.println(sampleHeading.getText());
		myActions.switchToFrame(0);
		WebElement childFrame = driver.findElement(By.xpath("/html/body/p"));
		System.out.println(childFrame.getText());
		
		driver.switchTo().parentFrame();
		 sampleHeading = driver.findElement(By.xpath("/html/body"));
		System.out.println(sampleHeading.getText());
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]")).getText());
	}
	
	
}
