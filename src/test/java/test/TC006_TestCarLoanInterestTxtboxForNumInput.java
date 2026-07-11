package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC006_TestCarLoanInterestTxtboxForNumInput extends BaseTest {
	
	@Test(dataProvider="CarInterestAmountnum",dataProviderClass=DataProviders.class)
	public void testCarLoanInterestTextbox(String loanInterestTextBoxValue) {
		
		log.info("TC006 Started");
		
		Home home=new Home(driver);
		
		home.navToCarLoan();
		
		String carLoanInterestTextboxValue=home.getCarLoanInterestTxtboxValueForNumInput(loanInterestTextBoxValue);
		
		try {
			Assert.assertEquals(carLoanInterestTextboxValue,loanInterestTextBoxValue);
		}catch(AssertionError e) {
			
			log.error("TC006 Failed : Car loan interest input field should accept number input");
			e.printStackTrace();
			Assert.fail("Interest input field should accept number input");
			
		}
		
		log.info("TC006 Passed : Car Loan Interest textbox accept number input");
		
	}
}
