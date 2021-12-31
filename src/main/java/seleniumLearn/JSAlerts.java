package seleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlerts {
	static By alertButton = By.id("alertButton");
	static By confirmButton = By.id("confirmButton");
	static By confirmResult = By.id("confirmResult");
	static By promtButton = By.id("promtButton");
	static By promptResult = By.id("promptResult");
	
	InitalizeBrowser initBrowser = new InitalizeBrowser();
	WebDriver driver = initBrowser.launchBrowser("chrome");
	
	ElementActions actions = new ElementActions(driver);

	
	public void tc1() {		

		actions.doClick(alertButton);
		String alertMessage = actions.getAlertMessage();

		if(alertMessage.equals("You clicked a button")) {
			System.out.println("Test case 1 passed");
		}else {
			System.out.println("Test Case 1 Failed");
		}
		
		actions.confirmAlert();
	}
	
	public void tc2() throws InterruptedException {
		actions.doClick(confirmButton);
		Thread.sleep(5000);
		actions.confirmAlert();
		
		String selectedResult = actions.getElementText(confirmResult);
		
		if(selectedResult.equals("You selected Ok")) {
			System.out.println("Test case 2 passed");
		}else {
			System.out.println("Test Case 2 Failed");
		}
	}
	
	public void tc3(String promptValue) throws InterruptedException {
		actions.doClick(promtButton);
		Thread.sleep(5000);
		actions.promptAlert(promptValue);
		Thread.sleep(5000);
		actions.confirmAlert();
		
		String selectedResult = actions.getElementText(promptResult);
		
		if(selectedResult.equals("You entered " + promptValue)) {
			System.out.println("Test case 3 passed");
		}else {
			System.out.println("Test Case 3 Failed");
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		JSAlerts t1 = new JSAlerts();
		t1.tc1();
		t1.tc2();
		t1.tc3("Hitesh");
	}

}
