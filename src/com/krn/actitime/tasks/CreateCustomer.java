package com.krn.actitime.tasks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.BaseClass;

public class CreateCustomer extends BaseClass{
	@Test(timeOut=2000)
	public void CreateCustomer() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//span[text()='Tasks']")).click();
		driver.findElement(By.xpath("//div[@class = 'addNewButton']")).click();
		driver.findElement(By.xpath("//div[text()='New Customer']")).click();
		String customerName = exlib.exceldata("Customer", 1, 0);
		driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")).sendKeys(customerName);
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		}
	
}
