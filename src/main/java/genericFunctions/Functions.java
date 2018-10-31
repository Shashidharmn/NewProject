package genericFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Functions {
	
	public void setData(WebDriver driver, String element,String data)
	{
		driver.findElement(By.xpath(element)).sendKeys(data);
	}

	public void click(WebDriver driver, String element)
	{
		driver.findElement(By.xpath(element)).click();
	}
	
	public void selectByValue(WebDriver driver, String element,String data)
	{
		Select sel=new Select(driver.findElement(By.xpath(element)));
		
		sel.selectByValue(data);
	}
}
