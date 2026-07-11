package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;


public class TC001_CorrectWebPageValidation extends BaseTest{
	
	@Test(groups= {"smoke"})
	public void webPage() {
		
		log.info("TC001 Started");
		
		Home home=new Home(driver);
		String title=home.getTitle();
		try {
			Assert.assertEquals(props.getProperty("title"),title);
		}catch(AssertionError e) {
			log.error("TC001 Failed : Page title is not as expected");
			System.out.println(e.getMessage());
			return;
		}
		
		log.info("TC001 Passed : Navigated to home page");
		System.out.println("Navigated to home page successfully");
		
	}
}

