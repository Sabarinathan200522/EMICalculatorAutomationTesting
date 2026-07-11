package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC003_TestCarLoanAmtTxtboxForStrInput extends BaseTest {
	
	@Test(dataProvider="CarLoanAmountstr",dataProviderClass=DataProviders.class)
	public void testCarLoanAmtText(String loanAmountTextBoxValue) {
		
		log.info("TC003 Started");
		
		Home home=new Home(driver);
		
		home.navToCarLoan();
		
		String carLoanAmtTextValue=home.getCarLoanAmtTxtboxValueForStrInput(loanAmountTextBoxValue);
		
		try {
			Assert.assertEquals(carLoanAmtTextValue,"0");
		}catch(AssertionError e) {
			
			log.error("TC003 Failed : Car loan amount input field should not accept string input");
			e.printStackTrace();
			Assert.fail("Amount input field should not accept string input");
			
		}
		
		log.info("TC003 Passed : Car Loan Amount textbox did not accept string input and set default value 0");
		
	}
	
}
