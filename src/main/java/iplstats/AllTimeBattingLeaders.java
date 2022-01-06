package iplstats;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumLearn.InitalizeBrowser;

public class AllTimeBattingLeaders {

	public static void main(String[] args) {


		By battingCategories = By.xpath("//h2[text()='All Time Bowling Leaders']//preceding::div[@class='cap-holder-title']");

		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");


		initBrowser.setupBrower();
		// to launch URL
		driver.get("https://www.iplt20.com/stats/all-time");

		
		AllTimeLeaders leaders = new AllTimeLeaders(driver,battingCategories);
		System.out.println("All Time Batting Leaders");
		System.out.println("===============================================");
		leaders.getAllTimeLeaders();
		
	}
	

	
}
