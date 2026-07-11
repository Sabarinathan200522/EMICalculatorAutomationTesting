package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC009_TestCarLoanTenureMonthToYear extends BaseTest{

	@Test(dataProvider="CarLoanTenureMonthYear",dataProviderClass=DataProviders.class,groups= {"ui-sync"})
	public void testCarLoanTenureMonthToYear(String year,String month) {
		
		log.info("TC009 Started");
		Home home=new Home(driver);
		home.navToCarLoan();
		String txtYear=home.carLoanTenureMonthToYear(month);
		try {
			Assert.assertEquals(txtYear,year);
		}catch(AssertionError e) {
			log.error("TC009 Failed : Month to year conversion is not working");
			e.printStackTrace();
			Assert.fail("Month to year conversion is not working");
		}
		
		log.info("TC009 Passed : Month to year conversion is successfull");
		
	}
}
