package com.shashi.data;

import org.testng.annotations.DataProvider;

public class ReadData {
	
	@DataProvider(name = "data")
	public Object[][] getData() throws Exception {
		
		ExcelData excelUtils=new ExcelData();
		return excelUtils.getTableArray("C:\\Users\\Shashi\\Desktop\\Data.xlsx", "Sheet1");
	 
		
		
	}

}
