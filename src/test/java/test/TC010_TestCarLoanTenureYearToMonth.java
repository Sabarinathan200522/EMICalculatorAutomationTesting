package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC010_TestCarLoanTenureYearToMonth extends BaseTest {
	
	@Test(dataProvider="CarLoanTenureMonthYear",dataProviderClass=DataProviders.class,groups= {"ui-sync"})
	public void testCarLoanTenureMonthToYear(String year,String month) {
		
		log.info("TC010 Started");
		Home home=new Home(driver);
		home.navToCarLoan();
		String txtMonth=home.carLoanTenureYearToMonth(year);
		try {
			Assert.assertEquals(txtMonth,month);
		}catch(AssertionError e) {
			log.error("TC010 Failed : Year to month conversion is not working");
			e.printStackTrace();
			Assert.fail("Year to month conversion is not working");
		}
		
		log.info("TC010 Passed : Year to month conversion is successfull");
		
	}
}
