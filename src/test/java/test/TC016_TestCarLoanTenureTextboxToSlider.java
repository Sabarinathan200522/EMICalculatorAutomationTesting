package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import utilities.DataProviders;

public class TC016_TestCarLoanTenureTextboxToSlider extends BaseTest {
	@Test(dataProvider="CarTenureAmountnum",dataProviderClass=DataProviders.class,groups= {"ui-sync"})
	public void testCarLoanTenureTextboxToSlider(String slider) {
		
		log.info("TC016 Started");
		Home home=new Home(driver);
		home.navToCarLoan();
		int textValue=Integer.parseInt(slider);
		int sliderMaxValue=7;
		String sliderValue=home.carLoanTenureTextboxToSlider(textValue,sliderMaxValue);
		
		if(textValue<=sliderMaxValue){
			
			try { 
				Assert.assertEquals(sliderValue,textValue+"");
			}catch(AssertionError e) {
				log.error("TC016 Failed : Textbox value does not reflect on corresponding slider");
				e.printStackTrace();
				Assert.fail("Textbox value does not reflect on corresponding slider");
			}
			log.info("TC016 Passed : Textbox value successfully reflect on corresponding slider");
		}else {
			
			try {
				Assert.assertEquals(sliderValue,sliderMaxValue+"");
			}catch(AssertionError e) {
				log.error("TC016 Failed : Textbox value does not reflect on corresponding slider");
				e.printStackTrace();
				Assert.fail("Textbox value does not reflect on corresponding slider");
			}
			log.info("TC016 Passed : Textbox value successfully reflect on corresponding slider but textbox value exceed slider max value so slider points on its max point");
			System.out.println("TC016 Passed : Textbox value successfully reflect on corresponding slider but textbox value exceed slider max value so slider points on its max point");
		}
		
		
		
		
	}
}
