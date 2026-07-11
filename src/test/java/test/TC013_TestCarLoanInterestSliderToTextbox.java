package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC013_TestCarLoanInterestSliderToTextbox extends BaseTest{

	@Test(dataProvider="CarInterestAmountnum",dataProviderClass=DataProviders.class,groups= {"ui-sync"})
	public void testCarLoanInterestSliderToTextbox(String slider) {
		
		log.info("TC013 Started");
		Home home=new Home(driver);
		home.navToCarLoan();
		double sliderValue=Double.parseDouble(slider);
		String sliderStrValue=sliderValue+"";
		String txtValue=home.carLoanInterestSliderToTextbox(sliderValue);
		if(txtValue.indexOf('.')==-1) {
			txtValue=txtValue+".0";
		}
		try {
			Assert.assertEquals(txtValue,sliderStrValue);
		}catch(AssertionError e) {
			log.error("TC013 Failed : Slider value does not reflect on corresponding textbox");
			e.printStackTrace();
			Assert.fail("Slider value does not reflect on textbox");
		}
		
		log.info("TC013 Passed : Slider value successfully reflect on corresponding textbox");
		
	}
}
