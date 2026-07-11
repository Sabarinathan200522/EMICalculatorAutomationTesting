package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC014_TestCarLoanInterestTextboxToSlider extends BaseTest {

	@Test(dataProvider="CarInterestAmountnum",dataProviderClass=DataProviders.class,groups= {"ui-sync"})
	public void testCarLoanInterestTextboxToSlider(String slider) {
		
		log.info("TC014 Started");
		Home home=new Home(driver);
		home.navToCarLoan();
		int textValue=Integer.parseInt(slider);
		int sliderMaxValue=20;
		String sliderValue=home.carLoanInterestTextboxToSlider(textValue,sliderMaxValue);
		
		if(textValue<sliderMaxValue){
			
			try { 
				Assert.assertEquals(sliderValue,textValue+"");
			}catch(AssertionError e) {
				log.error("TC012 Failed : Textbox value does not reflect on corresponding slider");
				e.printStackTrace();
				Assert.fail("Textbox value does not reflect on corresponding slider");
			}
			log.info("TC011 Passed : Textbox value successfully reflect on corresponding slider");
		}else {
			
			try {
				Assert.assertEquals(sliderValue,sliderMaxValue+"");
			}catch(AssertionError e) {
				log.error("TC012 Failed : Textbox value does not reflect on corresponding slider");
				e.printStackTrace();
				Assert.fail("Textbox value does not reflect on corresponding slider");
			}
			log.info("TC011 Passed : Textbox value successfully reflect on corresponding slider but textbox value exceed slider max value so slider points on its max point");
			System.out.println("TC011 Passed : Textbox value successfully reflect on corresponding slider but textbox value exceed slider max value so slider points on its max point");
		}
		
		
		
		
	}
}
