package seleniumLearn;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class ElementActions {

	WebDriver driver;
	
	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}

	
	
	//initial browser settings
	public void setupBrower() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	//generic methods to launch url
	public void launchUrl(String url) {
		driver.get(url);
	}

	//generic method to getElement by locator
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	//generic sendKeys method
	public void doSendKeys(By locator, String value) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(value);
	}

	//generic click method
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String getElementText(By locator) {
		WebElement element = getElement(locator);
		String text = element.getText();
		return text;
	}
	
	
	//get JS alert messages
	public String getAlertMessage() {
		String alertMessage = driver.switchTo().alert().getText();
		return alertMessage;
	}
	
	//click ok or accept js alert messages
	public void confirmAlert() {
		driver.switchTo().alert().accept();;
	}
	
	//dismiss or no js alert messages
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	//enter input in js alert message
	public void promptAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	//select drop down values by visible text for drop down with select tag
	public void selectDropDownValue(By locator, String value) {
		WebElement element = getElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	//select drop down value by index for drop down with select tag
	public void selectDropDownValue(By locator, int index) {
		WebElement element = getElement(locator);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	//get all drop down options for drop down with select tag
	public  ArrayList<String> getAllDropdownOptions(By locator) {
		ArrayList<String> options = new ArrayList<String>();
		WebElement element = getElement(locator);
		Select select = new Select(element);
		List<WebElement> colorsList = select.getOptions();
		
		for(WebElement color:colorsList) {
			String text = color.getText();
			options.add(text);
			//System.out.println(color.getText());
		}
		
		return options;
	}
	
	//select drop down value without select tag
	public void selectDropDownValueWithoutSelect(List<WebElement> list) {
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
