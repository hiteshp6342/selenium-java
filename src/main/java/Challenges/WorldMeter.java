package Challenges;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorldMeter {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchBrowser("chrome");
		driver.get("https://www.worldometers.info/world-population/");

		WebElement currentPopulation = driver.findElement(By.xpath("//span[@rel='current_population']"));

		// counter
		int countStart = 1;
		int countEnd = 20;

		ArrayList<String> todayAndThisYearList = getTodayAndThisYearData();
		while (countStart <= countEnd) {
			System.out.print(countStart + "sec \n");
			System.out.print("Current Population: " + currentPopulation.getText() + "\n");
			System.out.print("Today \n");
			System.out.print("Births: " + todayAndThisYearList.get(0) + "\t\t");
			System.out.print("Deaths: " + todayAndThisYearList.get(1) + "\t\t");
			System.out.print("Population Growth: " + todayAndThisYearList.get(2) + "\n");
			System.out.print("This Year \n");
			System.out.print("Births: " + todayAndThisYearList.get(3) + "\t");
			System.out.print("Deaths: " + todayAndThisYearList.get(4) + "\t");
			System.out.print("Population Growth: " + todayAndThisYearList.get(5) + "\n\n");

			// stop for 1 second
			Thread.sleep(1000);
			countStart++;
		}
		driver.close();
	}

	public static WebDriver launchBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

	public static ArrayList<String> getTodayAndThisYearData() {
		ArrayList<String> list = new ArrayList<String>();
		List<WebElement> todayAndThisYearList = driver
				.findElements(By.xpath("//div[@class='col1in' or @class='col2in']//child::span[@class='rts-counter']"));

		for (WebElement ele : todayAndThisYearList) {
			list.add(ele.getText());
		}

		return list;
	}

}



