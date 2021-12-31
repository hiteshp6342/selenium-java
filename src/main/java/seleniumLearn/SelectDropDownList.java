package seleniumLearn;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownList {

	public static void main(String[] args) {
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		ElementActions actions = new ElementActions(driver);
		actions.launchUrl("https://demoqa.com/select-menu");
		
//		WebElement colors = driver.findElement(By.id("oldSelectMenu"));
//		WebElement cars = driver.findElement(By.id("cars"));
		
		By colors = By.id("oldSelectMenu");
		By cars = By.id("cars");
		
//		ArrayList<String> colorOptions = getAllDropdownOptions(colors);
//		System.out.println(colorOptions);
//		
//		ArrayList<String> carsOptions = getAllDropdownOptions(cars);
//		System.out.println(carsOptions);
		
		ArrayList<String> colorOptions = actions.getAllDropdownOptions(colors);
		System.out.println(colorOptions);
	}
	
	public static ArrayList<String> getAllDropdownOptions(WebElement element) {
		ArrayList<String> options = new ArrayList<String>();
		
		Select select = new Select(element);
		List<WebElement> colorsList = select.getOptions();
		
		for(WebElement color:colorsList) {
			String text = color.getText();
			options.add(text);
			//System.out.println(color.getText());
		}
		
		return options;
	}
	

}
