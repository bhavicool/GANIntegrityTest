package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends Page{
	
	public HomePage(WebDriver driver) {
        super(driver);
    }
	

	public WebElement learnLink(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//a[text()='learn']")));
	}

	public WebElement connectedCOOBlogLink(WebDriver driver)
	{
		return (driver.findElement(By.xpath("//a[@href='https://www.ganintegrity.com/blog/']//div[@class='text-holder']//strong")));
	}
	
	public WebElement resourceCenterLink(WebDriver driver)
	{
		return (driver.findElement(By.xpath("//strong[text()='Resource Center']")));
	}
	
	

	public void selectconnectedCOOBlog() throws InterruptedException
	{

		waitForElement(learnLink(driver));
		
		learnLink(driver).click();
		
		Actions actions = new Actions(driver);	
		actions.moveToElement(connectedCOOBlogLink(driver)).click().perform();
		
	}
	
	public void selectresourceCenterBlog() throws InterruptedException
	{

		waitForElement(learnLink(driver));
		
		learnLink(driver).click();
		
		Actions actions = new Actions(driver);	
		actions.moveToElement(resourceCenterLink(driver)).click().perform();
		
	}

	}