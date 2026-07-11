package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC004_TestCarLoanAmtTxtboxForNumInput extends BaseTest {
	
	@Test(dataProvider="CarLoanAmountnum",dataProviderClass=DataProviders.class)
	public void testCarLoanAmtText(String loanAmountTextBoxValue) {
		
		log.info("TC004 Started");
		
		Home home=new Home(driver);
		home.navToCarLoan();
		String carLoanAmtTextValue=home.getCarLoanAmtTxtboxValueForNumInput(loanAmountTextBoxValue);
		try {
			Assert.assertEquals(carLoanAmtTextValue,loanAmountTextBoxValue);
		}catch(AssertionError e) {
			log.error("TC004 Failed : Car loan amount input field should  accept number input");
			e.printStackTrace();
			Assert.fail("Amount input field should accept Number input");
		}
		
		log.info("TC004 Passed : Car Loan Amount textbox accept number input");
		
	}
	
}
