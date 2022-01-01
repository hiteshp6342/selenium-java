package seleniumLearn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultiSelectDropDown {

	public static void main(String[] args)   {
		
		By dropDown = By.id("justAnInputBox");
		By dropDownList = By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]/ul//li/span[@class='comboTreeItemTitle']");

		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		
		ElementActions actions = new ElementActions(driver);
		
		actions.launchUrl("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		actions.doClick(dropDown);

		//actions.multiSelectDropDownValues(dropDownList, "choice 2", "choice 2 1", "choice 6 2 1");
		actions.multiSelectDropDownValues(dropDownList, "choice 2");
		//actions.multiSelectDropDownValues(dropDownList,"all");
	}

}
