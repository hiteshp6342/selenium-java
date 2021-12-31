package seleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		ElementActions actions = new ElementActions(driver);
		actions.launchUrl("https://demoqa.com/select-menu");
		
		//WebElement colors = driver.findElement(By.id("oldSelectMenu"));
		//WebElement cars = driver.findElement(By.id("cars"));
		
		By colors = By.id("oldSelectMenu");
		By cars = By.id("cars");
		
//		Select select = new Select(colors);
//		select.selectByVisibleText("Yellow");
//		
//		Select select1 = new Select(cars);
//		select1.selectByVisibleText("Saab");
		
//		selectDropDownValue(colors, "Yellow");
//		selectDropDownValue(cars, "Saab");
		
//		actions.selectDropDownValue(colors, "Yellow");
//		actions.selectDropDownValue(cars, "Saab");
		
		actions.selectDropDownValue(colors, 3);
		actions.selectDropDownValue(cars, 1);

	}
	
	public static void selectDropDownValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

}
