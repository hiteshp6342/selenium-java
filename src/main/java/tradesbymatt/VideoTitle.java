package tradesbymatt;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumLearn.InitalizeBrowser;

public class VideoTitle {

	public static void main(String[] args) throws InterruptedException {
		InitalizeBrowser initBrowser = new InitalizeBrowser();
		WebDriver driver = initBrowser.launchBrowser("chrome");
		
		initBrowser.setupBrower();
		// to launch URL
		driver.get("https://www.youtube.com/c/TradesbyMatt/videos");
		
		List<WebElement> titles = driver.findElements(By.cssSelector("a#video-title"));
		
		int positiveAmount = 0;
		int negativeAmount = 0;
		
		for(int i =0;i<titles.size();i++) {
			String amt = titles.get(i).getText();
			//\\d[\\d,.]*\\b
			//[\d\-+$,]+
			//[\+\-\$\d,]*\b
			Matcher matcher = Pattern.compile("[\\+\\-\\$\\d,]*\\b").matcher(amt);
			if (matcher.find()) {
			    String someNumberStr = matcher.group();
			   System.out.println(someNumberStr);
			    
			    if(someNumberStr.contains("+")) {
			    	int num = Integer.parseInt(someNumberStr.replaceAll("[\\+\\-\\$,]", ""));
			    	positiveAmount = positiveAmount+num;
			    }else if(someNumberStr.contains("-")) {
			    	 int num = Integer.parseInt(someNumberStr.replaceAll("[\\+\\-\\$,]", ""));
			    	negativeAmount = negativeAmount+num;
			    }
			}
			
		}
		
		System.out.println("Total Postive Trades " + positiveAmount + " and " + " Total of negative trades" + negativeAmount);
		System.out.println("Total Money Made : " + (positiveAmount-negativeAmount));
	}

}
