package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC021_CarLoan_Validation extends BaseTest{
	
	@Test(dataProvider="CarLoanData",dataProviderClass=DataProviders.class,groups= {"e2e"})
	public void CarLoan_Validation(String h1,String h2,String h3,String h4,String h5,String h6) {
		Home action=new Home(driver);
		action.navToCarLoan();
		action.setCarLoanAmount(h1);
		action.setInterestRate(h2);
		action.setLoanTenure(h3);
		action.click_Result();
		System.out.println(action.getLoanEmi()+" "+action.getTotalInterest()+" "+action.getTotalPayment());
		System.out.println(h4+" "+h5+" "+h6);
		Assert.assertEquals(action.getLoanEmi(), h4);
		Assert.assertEquals(action.getTotalInterest(), h5);
		Assert.assertEquals(action.getTotalPayment(), h6);
	}
}
