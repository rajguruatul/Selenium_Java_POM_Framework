package TestFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.baseTest;


public class NavigationBarTests extends baseTest
{

	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver intialized");
		driver.get(url);
		log.info("Navigated to HomePage");
	}
	
	@Test
	public void validateNavigationBar() throws IOException
	{
	
		HomePage homePageObj=new HomePage(driver);
		
		//assert the Navigation Bar if present
		Assert.assertTrue(homePageObj.getNavigationBar().isDisplayed());
		log.info("navigation Bar displayed successfully");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("Closing the Browser");
	}
	
	
	

}
