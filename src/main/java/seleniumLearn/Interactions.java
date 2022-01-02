package seleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Interactions {

	public static void main(String[] args) throws InterruptedException {
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		ElementActions myActions = new ElementActions(driver);
		
		initBrowser.setupBrower();		
		//to launch URL 
		myActions.launchUrl("http://automationpractice.com/index.php");
		
//		Thread.sleep(5000);
		By dressesMenu = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a");
		By casualDresses = By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a");

		
		//user this url for below elements - https://demoqa.com/menu
		//By menu2 = By.linkText("Main Item 2");
		//By subsub = By.xpath("//*[@id='nav']/li[2]/ul/li[3]/a");
		//By subsubitem2 = By.xpath("//*[@id='nav']/li[2]/ul/li[3]/ul/li[2]/a");

		
		myActions.doMoveToElement(dressesMenu);
		myActions.doActionsClick(casualDresses);
		
		
		//Drag and Drop
		//WebElement source = driver.findElement(By.id("draggable"));
		//WebElement traget = driver.findElement(By.id("droppable"));

		
		//Actions actions = new Actions(driver);
		
		//actions.clickAndHold(source).moveToElement(traget).release().build().perform();
		//actions.dragAndDrop(source, traget).build().perform();
		
		//right click
		//WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
		//actions.contextClick(rightClickButton).build().perform();
		
	}

}
