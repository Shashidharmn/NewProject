package com.shashi.implementation;

import genericFunctions.Functions;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shashi.pageObjetcs.LoginPageElement;



public class LoginPageImpl  extends Functions implements LoginPageElement {
	
	
	
	public void LoginPage( WebDriver driver, Object ...data)
	{
		
		setData(driver, FirstName, String.valueOf(data[0]));
		setData(driver, Surname, String.valueOf(data[1]));
		//click(driver, element);

	}

}
