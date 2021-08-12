package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ConnectCOOBlog extends Page{
	
	public ConnectCOOBlog(WebDriver driver) {
        super(driver);
    }
	

	public WebElement searchBox(WebDriver driver)
	{

		return (driver.findElement(By.cssSelector("div.load-more-holder>div>div>form>input[type='search']")));
	}
	
	public WebElement browseCategories(WebDriver driver)
	{

		return (driver.findElement(By.cssSelector("span[class='jcf-select-text'] span")));
	}
	
	public WebElement latestLegislation(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//span[text()='Latest in Legislation']")));
	}
	
	public WebElement clearDropDownIcon(WebDriver driver)
	{

		return (driver.findElement(By.cssSelector(".fas.fa-times-circle")));
	}
	
	public List<WebElement> noOfSearchResults(WebDriver driver)
	{

		return driver.findElements(By.cssSelector("article.post-preview"));
	}
	
	
	public void selectLatestLegislation(String searchText) throws InterruptedException
	{

		waitForElement(searchBox(driver));
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		
		//je.executeScript("arguments[0].scrollIntoView(true);",browseCategories(driver));
		je.executeScript("window.scrollBy(0,150)", "");
		searchBox(driver).sendKeys(searchText);
		
		
		waitForElement(browseCategories(driver));
		
        Actions action = new Actions(driver);
        action.moveToElement(browseCategories(driver)).perform();
        
        browseCategories(driver).click();
       //je.executeScript("arguments[0].click();", browseCategories(driver));
       latestLegislation(driver).click();
        //je.executeScript("arguments[0].click();", latestLegislation(driver));
		//waitForElementList(noOfSearchResults(driver));
	}
	
	public void selectLatestLegislationForReset(String searchText) throws InterruptedException
	{

		waitForElement(searchBox(driver));
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		
		//je.executeScript("arguments[0].scrollIntoView(true);",browseCategories(driver));
		je.executeScript("window.scrollBy(0,150)", "");
		searchBox(driver).sendKeys(searchText);
		
		
		waitForElement(browseCategories(driver));
		
        Actions action = new Actions(driver);
        action.moveToElement(browseCategories(driver)).perform();
        
        // browseCategories(driver).click();
       
        browseCategories(driver).click();
       //je.executeScript("arguments[0].click();", browseCategories(driver));
       
        //waitForElement(latestLegislation(driver));
		latestLegislation(driver).click();
        //je.executeScript("arguments[0].click();", latestLegislation(driver));
		//waitForElementList(noOfSearchResults(driver));
		Thread.sleep(2000);
		searchBox(driver).clear();
		
		clearDropDownIcon(driver).click();
		Thread.sleep(2000);
		
		
		
	}
	
	public String getBrowseCategoriesText()
	{
		return browseCategories(driver).getText();
	}
	
	public String getSearchPlaceholderValue()
	{
		return searchBox(driver).getAttribute("placeholder");
	}
	
	public int getSearchResults() throws InterruptedException
	{
		Thread.sleep(3000);
		return noOfSearchResults(driver).size();
	}
	
	
}
