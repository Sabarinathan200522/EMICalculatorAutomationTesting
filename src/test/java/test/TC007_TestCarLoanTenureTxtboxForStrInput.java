package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC007_TestCarLoanTenureTxtboxForStrInput extends BaseTest{
	
	@Test(dataProvider="CarLoanAmountstr",dataProviderClass=DataProviders.class)
	public void testCarLoanTenureTextbox(String loanTenureTextBoxValue) {
		
		log.info("TC007 Started");
		
		Home home=new Home(driver);
		
		home.navToCarLoan();
		
		String carLoanTenureTextboxValue=home.getCarLoanTenureTxtboxValueForStrInput(loanTenureTextBoxValue);
		
		try {
			Assert.assertEquals(carLoanTenureTextboxValue,"1");
		}catch(AssertionError e) {
			
			log.error("TC007 Failed : Car loan tenure input field should not accept string input");
			e.printStackTrace();
			Assert.fail("Tenure input field should not accept string input");
			
		}
		
		log.info("TC007 Passed : Car Loan Tenure textbox did not accept string input and set default value 1");
		
	}
}
