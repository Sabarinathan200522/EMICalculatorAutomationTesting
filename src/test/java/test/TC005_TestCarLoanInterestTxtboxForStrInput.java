package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC005_TestCarLoanInterestTxtboxForStrInput extends BaseTest{

	@Test(dataProvider="CarLoanAmountstr",dataProviderClass=DataProviders.class)
	public void testCarLoanInterestText(String loanInterestTextBoxValue) {
		
		log.info("TC005 Started");
		
		Home home=new Home(driver);
		
		home.navToCarLoan();
		
		String carLoanInterestTextboxValue=home.getCarLoanInterestTxtboxValueForStrInput(loanInterestTextBoxValue);
		
		try {
			Assert.assertEquals(carLoanInterestTextboxValue,"9");
		}catch(AssertionError e) {
			
			log.error("TC005 Failed : Car loan interest input field should not accept string input");
			e.printStackTrace();
			Assert.fail("Interest input field should not accept string input");
			
		}
		
		log.info("TC005 Passed : Car Loan Interest textbox did not accept string input and set default value 9");
		
	}
}
