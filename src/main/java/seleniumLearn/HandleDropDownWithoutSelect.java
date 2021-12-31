package seleniumLearn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleDropDownWithoutSelect {

	public static void main(String[] args) {
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");

		ElementActions actions = new ElementActions(driver);
		actions.launchUrl("https://demoqa.com/select-menu");

		List<WebElement> dropDownList = driver.findElements(By.xpath("//*[@id='oldSelectMenu']/option"));
		actions.selectDropDownValueWithoutSelect(dropDownList);
		

	}
	
	public static void selectDropDownValueWithoutSelect(List<WebElement> list) {
		for (WebElement element : list) {
			String value = element.getText();
			System.out.println(value);
			if (value.equals("Yellow")) {
				element.click();
				break;
			}
		}
	}

}
