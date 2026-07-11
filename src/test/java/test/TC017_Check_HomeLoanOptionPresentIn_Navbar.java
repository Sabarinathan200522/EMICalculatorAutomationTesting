package test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;

public class TC017_Check_HomeLoanOptionPresentIn_Navbar extends BaseTest {
	@Test(groups= {"smoke"})
	public void check_HomeLoanOptionPresentIn_Navbar() {
		Home action=new Home(driver);
		action.click_Loan_Widgets();
		List<String> navbar=action.loanWidgetsTypes();
		for(String option:navbar) {
			System.out.println("Options in the navbar :");
			System.out.println(option);
			if(option.equals("Home Loan EMI Calculator")) {
				Assert.assertTrue(true);
				return;
			}
		}
		Assert.assertTrue(false);
	}
}
