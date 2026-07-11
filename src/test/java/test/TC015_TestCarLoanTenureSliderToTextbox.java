package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC015_TestCarLoanTenureSliderToTextbox extends BaseTest{
	
	@Test(dataProvider="CarTenureAmountnum",dataProviderClass=DataProviders.class,groups= {"ui-sync"})
	public void testCarLoanTenuretSliderToTextbox(String slider) {
		
		log.info("TC015 Started");
		Home home=new Home(driver);
		home.navToCarLoan();
		double sliderValue=Double.parseDouble(slider);
		String sliderStrValue=sliderValue+"";
		String txtValue=home.carLoanTenureSliderToTextbox(sliderValue);
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
