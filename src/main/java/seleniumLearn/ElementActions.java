package seleniumLearn;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class ElementActions {

	WebDriver driver;

	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}



	// generic methods to launch url
	public void launchUrl(String url) {
		driver.get(url);
	}

	// generic method to getElement by locator
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	// get list of elements
	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		return elements;

	}

	// generic sendKeys method
	public void doSendKeys(By locator, String value) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(value);
	}

	// generic click method
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	
	/**
	 * sendkeys using actions class
	 * @param By locator
	 * @param String value
	 */
	public void doActionsSendKeys(By locator, String value) {
		WebElement element = getElement(locator);
		Actions action = new Actions(driver);
		action.sendKeys(element, value).build().perform();;
	}
	
	
	/**
	 * do click using actions class
	 * @param By locator
	 */
	public void doActionsClick(By locator) {
		WebElement element = getElement(locator);
		Actions action = new Actions(driver);
		action.click(element).build().perform();;
	}
	
	
	/**
	 * do moveToElement (Hover over element) using actions class
	 * @param By locator
	 */
	public void doMoveToElement(By locator) {
		WebElement element = getElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();;
	}
	
	
	/**
	 * do moveToElement (Hover over element) for menu and sub-menu using actions class
	 * @param By locator1
	 * @param By locator2
	 */
	public void doMoveToElement(By locator1, By locator2) {
		WebElement element1 = getElement(locator1);
		WebElement element2 = getElement(locator2);
		Actions action = new Actions(driver);
		action.moveToElement(element1).moveToElement(element2).build().perform();
	}
	

	public String getElementText(By locator) {
		WebElement element = getElement(locator);
		String text = element.getText();
		return text;
	}

	// get JS alert messages
	public String getAlertMessage() {
		String alertMessage = driver.switchTo().alert().getText();
		return alertMessage;
	}

	// click ok or accept js alert messages
	public void confirmAlert() {
		driver.switchTo().alert().accept();
	}

	// dismiss or no js alert messages
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	// enter input in js alert message
	public void promptAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	// select drop down values by visible text for drop down with select tag
	public void selectDropDownValue(By locator, String value) {
		WebElement element = getElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	// select drop down value by index for drop down with select tag
	public void selectDropDownValue(By locator, int index) {
		WebElement element = getElement(locator);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// get all drop down options for drop down with select tag
	public ArrayList<String> getAllDropdownOptions(By locator) {
		ArrayList<String> options = new ArrayList<String>();
		WebElement element = getElement(locator);
		Select select = new Select(element);
		List<WebElement> list = select.getOptions();

		for (WebElement ele : list) {
			String value = ele.getText();
			options.add(value);
			// System.out.println(color.getText());
		}

		return options;
	}

	// select drop down value without select tag -- Single selection
	public void singleSelectDropDownValueWithoutSelect(By locator, String value) {
		List<WebElement> list = getElements(locator);
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			//System.out.println(text);
			if (text.equals(value)) {
				list.get(i).click();
				break;
			}
		}
	}

	//
	/**
	 * select drop down value without select tag -- Multi selection - Pass 'ALL' or
	 * 'all' to select all values for dropdown
	 * 
	 * @param locator
	 * @param value
	 */
	public void multiSelectDropDownValues(By locator, String... value) {
		List<WebElement> list = getElements(locator);

		if (value[0].equalsIgnoreCase("ALL")) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).click();
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				String text = list.get(i).getText();
				//System.out.println(text);

				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						list.get(i).click();
						break;
					}
				}

			}
		}
	}

	// method to click on each link and verify link is working
	public void verifyLinks(By locator) {
		List<WebElement> links = getElements(locator);
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
			links.get(i).click();// stale element reference: element is not attached to the page document --
									// clicking link refreshes the dom
			driver.navigate().back(); // going back doesn't fix the problem
			links = getElements(locator);//update the element with new dom
		}
	}

}
