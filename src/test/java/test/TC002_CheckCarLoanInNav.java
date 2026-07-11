package test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;


public class TC002_CheckCarLoanInNav extends BaseTest {
	
	@Test(groups= {"smoke"})
	public void carLoanPresentOrNot() {

		log.info("TC002 Started");
		
		Home home=new Home(driver);
		
		List<String> loanTypes=home.loanTypes();
		
		for(String i:loanTypes) {
			if(i.equalsIgnoreCase("car loan")) {
				Assert.assertTrue(true);
				log.info("TC002 Passed : Car Loan present in the Navigation bar");
				return;
			}
		}
		
		try {
			Assert.fail();
		}catch(AssertionError e) {
			log.error("TC002 Failed : Car Loan not present in the Navigation bar");
			System.out.println(e.getMessage());
		}
		
	}
}
