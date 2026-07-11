package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import pages.HomeLoanActions;

public class TC020_Check_GraphAndTablePresentedOrNot_For_HomeLoan extends BaseTest{
	
	@Test
	public void check_GraphAndTablePresentedOrNot_For_HomeLoan() {
		
		log.info("TC020 Started");
		HomeLoanActions action=new HomeLoanActions(driver);
		Home homeaction=new Home(driver);
		homeaction.click_Loan_Widgets();
		homeaction.click_Home_Loan_Page();
		Assert.assertTrue(action.graphIsPresented());
		Assert.assertTrue(action.tableForHomeLoanIsPresented());
		log.info("TC020 Passed : The graph and table is visible for validated home loan");
	}
}
