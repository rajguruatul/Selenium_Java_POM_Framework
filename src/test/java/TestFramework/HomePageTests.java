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


public class HomePageTests extends baseTest
{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver intialized");
		driver.get(url);
		log.info("Navigated to HomePage : "+ url);
	}

	@Test
	public void basePageNavigation() throws IOException
	{
	
		HomePage homePageObj=new HomePage(driver);
		
		//assert
		Assert.assertEquals(homePageObj.getFeatureTitle().getText(), "FEATURED COURSES");
		log.info("Successfully verified the Categoty Title");

	}
	

	
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("Closing the Browser");
	}

}
