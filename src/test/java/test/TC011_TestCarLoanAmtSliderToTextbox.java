package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC011_TestCarLoanAmtSliderToTextbox extends BaseTest{
	
	@Test(dataProvider="CarLoansliderValue",dataProviderClass=DataProviders.class,groups= {"ui-sync"})
	public void testCarLoanAmtSliderToTextbox(Double sliderValue) {
		
		log.info("TC011 Started");
		Home home=new Home(driver);
		home.navToCarLoan();
		String txtValue=home.carLoanAmtSliderToTextbox(sliderValue);
		if(txtValue.indexOf('.')==-1) {
			txtValue=txtValue+".0";
		}
		try {
			Assert.assertEquals(txtValue,sliderValue+"");
		}catch(AssertionError e) {
			log.error("TC011 Failed : Slider value does not reflect on corresponding textbox");
			e.printStackTrace();
			Assert.fail("Slider value does not reflect on textbox");
		}
		
		log.info("TC011 Passed : Slider value successfully reflect on corresponding textbox");
		
	}
}
