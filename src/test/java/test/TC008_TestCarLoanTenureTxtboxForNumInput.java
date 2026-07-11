package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC008_TestCarLoanTenureTxtboxForNumInput extends BaseTest {

	@Test(dataProvider="CarTenureAmountnum",dataProviderClass=DataProviders.class)
	public void testCarLoanTenureTextbox(String loanTenureTextBoxValue) {
		
		log.info("TC008 Started");
		
		Home home=new Home(driver);
		
		home.navToCarLoan();
		
		String carLoanTenureTextboxValue=home.getCarLoanTenureTxtboxValueForNumInput(loanTenureTextBoxValue);
		
		try {
			Assert.assertEquals(carLoanTenureTextboxValue,loanTenureTextBoxValue);
		}catch(AssertionError e) {
			
			log.error("TC008 Failed : Car loan tenure input field should accept only number input");
			e.printStackTrace();
			Assert.fail("Tenure input field should accept only  number input");
			
		}
		
		log.info("TC008 Passed : Car Loan Tenure textbox accept number input");
		
	}
}
