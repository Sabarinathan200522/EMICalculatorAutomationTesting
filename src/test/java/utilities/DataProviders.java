package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\src\\test\\resources\\DataForHomeLoan.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols-1];
		
		for(int i=1;i<=totalrows;i++)  
		{		
			for(int j=1;j<totalcols;j++)  
			{
				logindata[i-1][j-1]= xlutil.getCellData("Sheet1",i, j); 
			}
		}
	return logindata;
				
	}
	
	@DataProvider(name="CarLoanData")
	public String [][] getCarLoanData() throws IOException
	{
		String path=".\\src\\test\\resources\\CarLoanData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols-1];
		
//		System.out.print(totalrows+" "+totalcols);
		for(int i=1;i<=totalrows;i++)  
		{		
			for(int j=1;j<totalcols;j++)  
			{
				logindata[i-1][j-1]= xlutil.getCellData("Sheet1",i, j);  
			}
		}
	return logindata;
				
	}
	//DataProvider 2
	@DataProvider(name="CarLoanAmountstr")
	public String [][] getCarLoanAmountstr() throws IOException
	{

		String logindata[][]= {
				{"dhuru"},
				{"Vikram"}
		};
		
	    return logindata;
				
	}
	//DataProvider 3
	@DataProvider(name="CarLoanAmountnum")
	public String [][] getCarLoanAmountnum() throws IOException
	{

		String logindata[][]= {
				{"1,00,000"},
				{"2,00,000"}
		};
		
	    return logindata;
				
	}
	//DataProvider 4
	@DataProvider(name="CarInterestAmountnum")
	public String [][] getCarInterestAmountnum() throws IOException
	{

		String logindata[][]= {
				{"9"},
				{"8"}
		};
		
	    return logindata;
				
	}
	
	@DataProvider(name="CarTenureAmountnum")
	public String [][] getCarTenureAmountnum() throws IOException
	{

		String logindata[][]= {
				{"5"},
				{"7"}
		};
		
	    return logindata;
				
	}
	
	@DataProvider(name="CarLoanTenureMonthYear")
	public String [][] getCarLoanTenureMonthYear() throws IOException
	{

		String logindata[][]= {
				{"1","12"},
				{"2","24"},
				{"5","60"}
		};
		
	    return logindata;
				
	}
	
	@DataProvider(name="CarLoansliderValue")
	public Double [][] getCarLoansliderValue() throws IOException
	{

		Double logindata[][]= {
				{1000000.0},
				{500000.0},
				{700000.0}
			
		};
		
	    return logindata;
				
	}
	
	@DataProvider(name="CarLoansliderValueInt")
	public Integer [][] getCarLoansliderValueInt() throws IOException
	{

		Integer logindata[][]= {
				{1000000},
				{500000},
				{700000}
			
		};
		
	    return logindata;
				
	}
	
}
