package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ConnectCOOBlog;
import pages.HomePage;
import pages.ResourceCenter;
import resources.ApplicationData;

public class GanIntegrityTest implements ApplicationData {

	private WebDriver driver;

	HomePage homePage;
	
	ConnectCOOBlog connectCOOBlog;
	
	ResourceCenter resourceCenter;
	

	@BeforeMethod()
	public void navigateToApplication()
	{
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();

		driver.get(applicationURL);

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePage=new HomePage(driver);
		
		connectCOOBlog=new ConnectCOOBlog(driver);
		
		resourceCenter=new ResourceCenter(driver);
	}

	//Test 1 scenario
	@Parameters({"searchText"} )
	@Test(priority=1)	
	public void latestLegislationTestCase(String searchText) throws InterruptedException{

		homePage.selectconnectedCOOBlog();
	    
	    connectCOOBlog.selectLatestLegislation(searchText);
	    
	    String URL = driver.getCurrentUrl();
	    //System.out.println("URL is:"+URL);
	    Assert.assertTrue(URL.contains("blog"));
	    
	    int searchCount=connectCOOBlog.getSearchResults();
	    //System.out.println("Search Count is:"+searchCount);
	    Assert.assertEquals(searchCount, 6);

	}
	
	//Test 2 scenario
	@Parameters({"searchText"} )
	@Test(priority=2)		
	public void clearSearchBoxTestCase(String searchText) throws InterruptedException{

		
		homePage.selectconnectedCOOBlog();
	    
	    connectCOOBlog.selectLatestLegislationForReset(searchText);
	    
	    String text=connectCOOBlog.getBrowseCategoriesText();
	    //System.out.println("Text is:"+text);
	    Assert.assertEquals("BROWSE CATEGORIES",text);
	    
	    String placeholdeText=connectCOOBlog.getSearchPlaceholderValue();
	    //System.out.println("Text is:"+placeholdeText);
	    Assert.assertEquals("Search...",placeholdeText);
	    

	}

	//Test 3 scenario
	@Test(priority=3)		
	public void resourceCenterTestCase() throws InterruptedException{

		homePage.selectresourceCenterBlog();
	    
	    Thread.sleep(4000);
	    
	    resourceCenter.resourceCenterFlow();
	    
	    String URL = driver.getCurrentUrl();
	    //System.out.println("URL is:"+URL);
	    Assert.assertTrue(URL.contains("resources"));
	}
	
	    
	    
	@AfterMethod
	public void quitDriver() throws Exception {
		driver.quit();
	}


}
