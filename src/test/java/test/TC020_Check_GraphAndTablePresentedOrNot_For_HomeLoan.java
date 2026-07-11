package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import pages.HomeLoanActions;

public class TC020_Check_GraphAndTablePresentedOrNot_For_HomeLoan extends BaseTest{
	
	@Test
	public void check_GraphAndTablePresentedOrNot_For_HomeLoan() {
		HomeLoanActions action=new HomeLoanActions(driver);
		Home homeaction=new Home(driver);
		homeaction.click_Loan_Widgets();
		homeaction.click_Home_Loan_Page();
		Assert.assertTrue(action.graphIsPresented());
		Assert.assertTrue(action.tableForHomeLoanIsPresented());
	}
}
