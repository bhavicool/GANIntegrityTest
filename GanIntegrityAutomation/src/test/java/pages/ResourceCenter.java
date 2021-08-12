package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResourceCenter extends Page {
	
	public ResourceCenter(WebDriver driver) {
        super(driver);
    }
	
	public WebElement viewByType(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//strong[text()='View by Type']")));
	}
	
	public WebElement viewByTypeeBook(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//span[text()='eBook']")));
	}
	
	public WebElement viewByProcess(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//strong[text()='View by Process']")));
	}
	
	public WebElement viewByTypepolicyDeployment(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//span[text()='Policy Deployment']")));
	}
	
	public void resourceCenterFlow() throws InterruptedException
	{

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,600)", "");
		
		waitForElement(viewByType(driver));
				
		Actions action = new Actions(driver);
		action.moveToElement(viewByType(driver)).perform();
		
		viewByType(driver).click();
		
		je.executeScript("window.scrollBy(0,100)", "");
		
		viewByTypeeBook(driver).click();
		
		Thread.sleep(2000);
		
		action.moveToElement(viewByProcess(driver)).perform();
		
		viewByProcess(driver).click();
		
		je.executeScript("window.scrollBy(0,100)", "");
		
		viewByTypepolicyDeployment(driver).click();
		
		Thread.sleep(3000);
	}
}
