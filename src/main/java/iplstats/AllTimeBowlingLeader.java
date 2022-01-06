package iplstats;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumLearn.InitalizeBrowser;

public class AllTimeBowlingLeader {

	public static void main(String[] args) {


		By bowlingCategories = By.xpath("//h2[text()='All Time Bowling Leaders']//following::div[@class='cap-holder-title']");
		//By playerFirstName = By.xpath("//div[text()='Orange cap']//following-sibling::div//child::p");
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");


		initBrowser.setupBrower();
		// to launch URL
		driver.get("https://www.iplt20.com/stats/all-time");
		
		AllTimeLeaders leaders = new AllTimeLeaders(driver,bowlingCategories);
		System.out.println("All Time Bowling Leaders");
		System.out.println("===============================================");

		leaders.getAllTimeLeaders();

		
	}
	


}
