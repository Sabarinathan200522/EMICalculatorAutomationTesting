package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import pages.HomeLoanActions;
import utilities.DataProviders;

public class TC019_HomeLoanValidation extends BaseTest {
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= {"e2e"})
	void validate_HomeLoan(String h1,String h2,String h3,String h4,String h5,String h6,String h7,String h8,String h9,String h10,String h11,String h12,String h13,String h14,String h15) throws Exception {
		HomeLoanActions action=new HomeLoanActions(driver);
		Home homeaction=new Home(driver);
		homeaction.click_Loan_Widgets();
		homeaction.click_Home_Loan_Page();
		action.setHomeValue(h1);
		action.setDownPayment(h2);
		action.setLoanIsurance(h3);
		action.setHomeLoanAmount(h4);
		action.setInterestRate(h5);
		action.setLoanTenure(h6);
		action.setLoanCharges(h7);
		action.setOneTimeExpenses(h10);
		action.setPropertyTaxes(h11);
		action.setIsurance(h12);
		action.setMaintences(h13);
		action.resultScroll();
		action.clickAction();
		System.out.println(action.getMonthPayment());
		System.out.println(action.getTotalPayment());
		System.out.println(h14+" "+h15);
		String monthPayment=action.getMonthPayment().substring(2);
		String totalPayment=action.getTotalPayment().substring(2);
		action.tableScroll();
		action.setTableValue();
		if(h14.equals(monthPayment)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		if(h15.equals(totalPayment)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
}
