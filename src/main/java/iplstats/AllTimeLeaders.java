package iplstats;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumLearn.ElementActions;

public class AllTimeLeaders {
	
	WebDriver driver;
	ElementActions myActions;
	By locator;
	ArrayList<String> ar = new ArrayList<String>();
	
	public AllTimeLeaders(WebDriver driver, By locator) {
		this.driver = driver;
		this.locator = locator;
	}
	
	public void getAllTimeLeaders() {
		
		 myActions = new ElementActions(driver);
		 List<WebElement> categories = myActions.getElements(locator);

			for (WebElement ele : categories) {
				ar.add(ele.getText());
			}
		
		for(int i = 0;i<ar.size();i++) {
			String cat = ar.get(i);
			String playerName = getPlayerName(cat, driver);
			String playerStats = getPlayerStat(cat, driver);
			System.out.println(cat +" - " +playerName + " - "+playerStats);
		}
	}

	public String getPlayerName(String category, WebDriver driver) {
		String playerFirstName = driver
				.findElement(By.xpath("//div[text()='" + category + "']//following-sibling::div//child::p")).getText();
		String playerLastName = driver
				.findElement(By.xpath("//div[text()='" + category + "']//following-sibling::div//child::p//following-sibling::div")).getText();
		String playerName = playerFirstName + " " + playerLastName;
		return playerName ;

	}
	
	public String getPlayerStat(String category, WebDriver driver) {
		String playerStat = driver
				.findElement(By.xpath("(//div[text()='" + category + "']//following-sibling::div//child::span)[1]")).getText();
		String statCat = driver
				.findElement(By.xpath("(//div[text()='" + category + "']//following-sibling::div//child::span)[2]")).getText();
		return playerStat + " " + statCat;
	}
}
