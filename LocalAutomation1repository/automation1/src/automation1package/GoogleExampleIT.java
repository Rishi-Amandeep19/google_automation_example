package automation1package;


import java.util.logging.Logger;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import junit.framework.Assert;

/*
 * Requirement:
 * 
 *  1. please fix all the bug in this file 
 *  2. please run it
 *  3. sent your test result and the fixed the file to us
 * 
 * 
 * */

public class GoogleExampleIT {
	
	private final static Logger LOGGER = Logger.getLogger(GoogleExampleIT.class.getName()); 
	
	private WebDriver driver = new FirefoxDriver();  
	
	@FindBy(css = "[name='q']")
	private WebElement searchBar;

   @Test
	public void googleCheeseExample() throws Exception {
		searchBar.clear();
		searchBar.sendKeys("Cheese!");
		searchBar.sendKeys(Keys.ENTER);
		LOGGER.info("Page title is: " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("Google"));
	}

	@Test //(enabled = true) - this feature is used in TestNG  
	public void googleMilkExample() throws Exception {
		searchBar.clear();
		searchBar.sendKeys("Milk!");
		searchBar.sendKeys(Keys.ENTER);
		LOGGER.info("Page title is: " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("Google"));
	}
	

	@Before
	public void setUp() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		driver.get("http://www.google.com");
	}

	@After
	public void tearDown() { 
		driver.close();

}	
}
