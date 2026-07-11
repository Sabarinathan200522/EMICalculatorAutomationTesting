package pages;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

public class HomeLoanActions extends BasePage{
	
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
	String formatted = now.format(formatter);
	ExcelUtility excel=new ExcelUtility(".\\TableData\\TableDataForHomeLoan_" + formatted +".xlsx");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public HomeLoanActions(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"homeprice\"]") 
	WebElement HomeValue;
	
	@FindBy(xpath="//*[@id=\"downpayment\"]") 
	WebElement DownPayment;
	
	@FindBy(xpath="//*[@id=\"homeloanamount\"]") 
	WebElement HomeLoanAmount;
	
	@FindBy(xpath="//*[@id=\"homeloaninterest\"]") 
	WebElement InterestRate;
	
	@FindBy(xpath="//*[@id=\"homeloanterm\"]") 
	WebElement LoanTenure;
	
	@FindBy(xpath="//*[@id=\"loanfees\"]") 
	WebElement LoanCharge;
	
	@FindBy(xpath="//*[@id=\"startmonthyear\"]") 
	WebElement LoanMonthAndYear;
	
	@FindBy(xpath="//*[@id=\"onetimeexpenses\"]") 
	WebElement OneTimeExpenses;
	
	@FindBy(xpath="//*[@id=\"propertytaxes\"]") 
	WebElement PropertyTax;
	
	@FindBy(xpath="//*[@id=\"homeinsurance\"]") 
	WebElement HomeInsurance;
	
	@FindBy(xpath="//*[@id=\"maintenanceexpenses\"]") 
	WebElement MaintenceExpenses;
	
	@FindBy(xpath="//*[@id=\"homeloaninsuranceamount\"]") 
	WebElement LoanInsurance;
	
	@FindBy(xpath="//*[@id=\"monthlyprincipalandinterestdef\"]") 
	WebElement TotalForMonth;
	
	@FindBy(xpath="//*[@id=\"monthlypayment\"]") 
	WebElement MonthPayment;
	
	@FindBy(xpath="//*[@id=\"totalpayment\"]") 
	WebElement TotalPayment;
	
	@FindBy(xpath="/html/body/div/div/main/article/div[3]/div/div[3]") 
	WebElement click;
	
	@FindBy(xpath="//table[@class=\"noextras\"]//tr//th") 
	List<WebElement> cols;
	
	@FindBy(xpath="//table[@class=\"noextras\"]//tr[@class=\"row no-margin yearlypaymentdetails\"]") 
	List<WebElement> rows;
	
	@FindBy(xpath="//*[@id=\"yearheader\"]") 
	WebElement Table;
	
	
	@FindBy(xpath="//div[@id=\"paymentschedulechart\"]") 
	WebElement Graph;
	
	@FindBy(xpath="//div[@id=\"paymentschedule\"]") 
	WebElement TableForHomeLoan;
	
	
	
	public void setHomeValue(String homevalue) throws Exception {
		HomeValue.clear();
		HomeValue.sendKeys(homevalue);
	}
	
	public void setDownPayment(String downpayment) throws Exception {
		DownPayment.clear();
		DownPayment.sendKeys(downpayment);
	}
	
	public void setHomeLoanAmount(String homeloanamount) throws Exception {
		HomeLoanAmount.clear();
		HomeLoanAmount.sendKeys(homeloanamount);
	}
	public void setInterestRate(String interestrate) throws Exception {
		InterestRate.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,Keys.chord(Keys.DOWN,interestrate));
	}
	public void setLoanTenure(String loantenure) throws Exception {
		LoanTenure.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,Keys.chord(Keys.DOWN,loantenure));
	}
	public void setLoanCharges(String loancharges) throws Exception {
		LoanCharge.clear();
		LoanCharge.sendKeys(loancharges);
	}
	public void setOneTimeExpenses(String onetimeexpenses) throws Exception {
		OneTimeExpenses.clear();
		OneTimeExpenses.sendKeys(onetimeexpenses);
	}
	public void setPropertyTaxes(String propertytaxes) throws Exception {
		PropertyTax.clear();
		PropertyTax.sendKeys(propertytaxes);
	}
	public void setIsurance(String insurance) throws Exception {
		HomeInsurance.clear();
		HomeInsurance.sendKeys(insurance);
	}
	public void setMaintences(String maintences) throws Exception {
		MaintenceExpenses.clear();
		MaintenceExpenses.sendKeys(maintences);
	}
	public void setLoanIsurance(String loanisurance) throws Exception {
		LoanInsurance.clear();
		LoanInsurance.sendKeys(loanisurance);
	}
	
	public void resultScroll() {
		js.executeScript("arguments[0].scrollIntoView();",TotalForMonth);
	}
	
	public void tableScroll() {
		js.executeScript("arguments[0].scrollIntoView();",Table);
	}
	
	public void clickAction() {
		click.click();
	}
	public String getMonthPayment() {
		return MonthPayment.getText();
	}
	
	public String getTotalPayment() {
		return TotalPayment.getText();
	}
	
	public boolean homeValueFieldIsPresented() {
		return HomeValue.isDisplayed();
	}
	
	public boolean downPaymentFieldIsPresented() {
		return DownPayment.isDisplayed();
	}
	
	public boolean homeLoanAmountFieldIsPresented() {
		return HomeLoanAmount.isDisplayed();
	}
	
	public boolean interestRateFieldIsPresented() {
		return InterestRate.isDisplayed();
	}
	
	public boolean loanTenureFieldIsPresented() {
		return LoanTenure.isDisplayed();
	}
	
	public boolean loanChargeFieldIsPresented() {
		return LoanCharge.isDisplayed();
	}
	
	public boolean loanMonthAndYearFieldIsPresented() {
		return LoanMonthAndYear.isDisplayed();
	}
	
	public boolean oneTimeExpensesFieldIsPresented() {
		return OneTimeExpenses.isDisplayed();
	}
	
	public boolean propertyTaxFieldIsPresented() {
		return PropertyTax.isDisplayed();
	}
	
	public boolean homeInsuranceFieldIsPresented() {
		return HomeInsurance.isDisplayed();
	}
	
	public boolean maintenceExpensesFieldIsPresented() {
		return MaintenceExpenses.isDisplayed();
	}
	
	public boolean loanInsuranceFieldIsPresented() {
		return LoanInsurance.isDisplayed();
	}
	
	public boolean graphIsPresented() {
		return Graph.isDisplayed();
	}
	
	public boolean tableForHomeLoanIsPresented() {
		return TableForHomeLoan.isDisplayed();
	}
	
	public void setTableValue() throws IOException{
		int n=rows.size()+1;
		int m=cols.size();
		String[][] list=new String[n][m];
		for(int i=1;i<=m;i++) {
			String h=driver.findElement(By.xpath("//table[@class=\"noextras\"]//tr//th["+i+"]")).getText();
			list[0][i-1]=h;
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<=m;j++) {
				String s=driver.findElement(By.xpath("//table[@class=\"noextras\"]//tr[@class=\"row no-margin yearlypaymentdetails\"]["+i+"]//td["+j+"]")).getText();
				list[i][j-1]=s;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				excel.setCellData("Sheet1", i, j,list[i][j]);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(list[i][j]+"  ");
			}
			System.out.println();
		}
	}
}
