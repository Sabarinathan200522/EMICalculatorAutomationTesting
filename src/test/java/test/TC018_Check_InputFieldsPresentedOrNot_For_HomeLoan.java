package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import pages.HomeLoanActions;

public class TC018_Check_InputFieldsPresentedOrNot_For_HomeLoan extends BaseTest{
	
	@Test(groups= {"smoke"})
	public void validate_HomeValue_InputFieldsPresentedOrNot_For_HomeLoan() {
		
		log.info("TC018 Started");
		HomeLoanActions action=new HomeLoanActions(driver);
		Home homeaction=new Home(driver);
		homeaction.click_Loan_Widgets();
		homeaction.click_Home_Loan_Page();
		Assert.assertTrue(action.homeValueFieldIsPresented());
		Assert.assertTrue(action.downPaymentFieldIsPresented());
		Assert.assertTrue(action.loanInsuranceFieldIsPresented());
		Assert.assertTrue(action.homeLoanAmountFieldIsPresented());
		Assert.assertTrue(action.interestRateFieldIsPresented());
		Assert.assertTrue(action.loanTenureFieldIsPresented());
		Assert.assertTrue(action.loanChargeFieldIsPresented());
		Assert.assertTrue(action.loanMonthAndYearFieldIsPresented());
		Assert.assertTrue(action.oneTimeExpensesFieldIsPresented());
		Assert.assertTrue(action.homeInsuranceFieldIsPresented());
		Assert.assertTrue(action.propertyTaxFieldIsPresented());
		Assert.assertTrue(action.maintenceExpensesFieldIsPresented());
		
		log.info("TC018 Passed : All the input fields present in the home loan page");
	}
}
