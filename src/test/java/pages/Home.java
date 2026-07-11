package pages;


import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends BasePage{
	
	public Home(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='loanproduct-nav']/li/a") List<WebElement> navbar;
	@FindBy(xpath="//a[normalize-space()='Car Loan']") WebElement carLoanBtn;
	
	@FindBy(xpath="//input[@id='loanamount']") WebElement carLoanAmtTextbox;
	@FindBy(xpath="//input[@id='loaninterest']") WebElement carLoanInterestTextbox;
	@FindBy(xpath="//input[@id='loanterm']") WebElement carLoanTenureTextbox;
	
	@FindBy(xpath="//label[normalize-space()='Mo']") WebElement loanTenureMonthBtn;
	@FindBy(xpath="//label[normalize-space()='Yr']") WebElement loanTenureYearBtn;
	
	@FindBy(xpath="//div[@id='loanamountslider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']") WebElement loanAmtSliderHandle;
	@FindBy(xpath="//div[@id='loanamountslider']//div[@class='ui-slider-range ui-corner-all ui-widget-header ui-slider-range-min']") WebElement loanAmtSlider;
	@FindBy(xpath="//div[@id='loanamountslider']") WebElement loanAmtFullSlider;
	

	@FindBy(xpath="//div[@id='loaninterestslider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']")WebElement loanInterestSliderHandle;
	@FindBy(xpath="//div[@id='loaninterestslider']//div[@class='ui-slider-range ui-corner-all ui-widget-header ui-slider-range-min']")WebElement loanInterestSlider;
	@FindBy(xpath="//div[@id='loaninterestslider']") WebElement loanInterestFullSlider;
	
	@FindBy(xpath="//div[@id='loantermslider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']")WebElement loanTenureSliderHandle;
	@FindBy(xpath="//div[@id='loantermslider']//div[@class='ui-slider-range ui-corner-all ui-widget-header ui-slider-range-min']")WebElement loanTenureSlider;
	@FindBy(xpath="//div[@id='loantermslider']") WebElement loanTenureFullSlider;
	
	@FindBy(xpath="//*[@id=\"menu-item-dropdown-2696\"]") 
	WebElement LoanWidgets;
	
	@FindBy(xpath="//*[@id=\"menu-item-3294\"]/a") 
	WebElement Home_Loan_Page;
	
	@FindBy(xpath="//li[@id=\"menu-item-2696\"]//ul//a") 
	List<WebElement> options;
	
	@FindBy(xpath="//div[@id=\"emiamount\"]/p/span")
	WebElement loanEmi;
	
	@FindBy(xpath="//div[@id=\"emitotalinterest\"]/p/span")
	WebElement totalInterest;
	
	@FindBy(xpath="//div[@id=\"emitotalamount\"]/p/span")
	WebElement totalPayment	;
	
	@FindBy(xpath="//*[@id=\"leschemewrapper\"]")
	WebElement result;
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public List<String> loanTypes(){
		return navBarListing(navbar);
	}
	
	public List<String> loanWidgetsTypes(){
		return navBarListing(options);
	}
	
	public void navToCarLoan() {
		carLoanBtn.click();
	}
	
	public String getCarLoanAmtTxtboxValueForStrInput(String loanAmountTextBoxValue) {
		
		return getTextBoxValue(carLoanAmtTextbox,carLoanBtn,loanAmountTextBoxValue);
	}
	
	public String getCarLoanAmtTxtboxValueForNumInput(String loanAmountTextBoxValue) {
		
		return getTextBoxValue(carLoanAmtTextbox,carLoanBtn,loanAmountTextBoxValue);
	}

	public String getCarLoanInterestTxtboxValueForStrInput(String loanInterestTextBoxValue) {
		
		return getTextBoxValue(carLoanInterestTextbox,carLoanBtn,loanInterestTextBoxValue);
	}
	
	public String getCarLoanInterestTxtboxValueForNumInput(String loanInterestTextBoxValue) {
		
		return getTextBoxValue(carLoanInterestTextbox,carLoanBtn,loanInterestTextBoxValue);
	}

	public String getCarLoanTenureTxtboxValueForStrInput(String loanTenureTextBoxValue) {
		return getTextBoxValue(carLoanTenureTextbox,carLoanBtn,loanTenureTextBoxValue);
	}
	
	public String getCarLoanTenureTxtboxValueForNumInput(String loanTenureTextBoxValue) {
		
		return getTextBoxValue(carLoanTenureTextbox,carLoanBtn,loanTenureTextBoxValue);
	}

	public String carLoanTenureMonthToYear(String month) {
		
		loanTenureMonthBtn.click();
		return getMonthYearTextboxValue(month,carLoanTenureTextbox,loanTenureYearBtn);
		
	}
	
	public String carLoanTenureYearToMonth(String year) {
		
		loanTenureYearBtn.click();
		return getMonthYearTextboxValue(year,carLoanTenureTextbox,loanTenureMonthBtn);
		
	}

	public String carLoanAmtSliderToTextbox(double sliderValue) {
		return sliderToTextbox(loanAmtFullSlider,loanAmtSliderHandle,loanAmtSlider,sliderValue,carLoanAmtTextbox,2000000.0,"interest slider");
		//return sliderToTextbox(loanAmtFullSlider,loanAmtSliderHandle,sliderValue,carLoanAmtTextbox,0,2000000.0);
	}
	
	public String carLoanAmtTextboxToSlider(int textValue,int sliderMaxValue) {
		return textboxToSlider(loanAmtSliderHandle,textValue,carLoanAmtTextbox,0,sliderMaxValue);
	}
	
	public String carLoanInterestSliderToTextbox(double sliderValue) {
		//return sliderToTextbox(loanInterestFullSlider,loanInterestSliderHandle,loanInterestSlider,sliderValue,carLoanInterestTextbox,15.0,"interest slider");
		return sliderToTextbox(loanInterestFullSlider,loanInterestSliderHandle,sliderValue,carLoanInterestTextbox,5,20.0);
	}
	
	public String carLoanInterestTextboxToSlider(int textValue,int sliderMaxValue) {
		return textboxToSlider(loanInterestSliderHandle,textValue,carLoanInterestTextbox,5.0,sliderMaxValue);
	}
	
	public String carLoanTenureSliderToTextbox(double sliderValue) {
		//return sliderToTextbox(loanTenureFullSlider,loanTenureSliderHandle,loanTenureSlider,sliderValue,carLoanTenureTextbox,7.0,"amount slider");
		return sliderToTextbox(loanTenureFullSlider,loanTenureSliderHandle,sliderValue,carLoanTenureTextbox,0,7.0);
	}
	
	public String carLoanTenureTextboxToSlider(int textValue,int sliderMaxValue) {
		return textboxToSlider(loanTenureSliderHandle,textValue,carLoanTenureTextbox,0,sliderMaxValue);
	}
	
	public void click_Loan_Widgets() {
		LoanWidgets.click();
	}
	
	public void click_Home_Loan_Page() {
		Home_Loan_Page.click();
	}
	
	public void setCarLoanAmount(String carloanamount) {
		carLoanAmtTextbox.clear();
		carLoanAmtTextbox.sendKeys(carloanamount);
	}
	
	public void setInterestRate(String interestrate) {
//		interestRate.clear();
		carLoanInterestTextbox.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,Keys.chord(Keys.DOWN,interestrate));
	}
	
	public void setLoanTenure(String loantenure) {
//		loanTenure.clear();
		carLoanTenureTextbox.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,Keys.chord(Keys.DOWN,loantenure));
	}
	
	public String getLoanEmi() {
		return loanEmi.getText();
	}
	
	public String getTotalInterest() {
		return totalInterest.getText();
	}
	
	public String getTotalPayment() {
		return totalPayment.getText();
	}
	
	public void click_Result() {
		result.click();
	}
}
