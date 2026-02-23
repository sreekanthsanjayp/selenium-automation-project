package com.krn.actitime.tasks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.BaseClass;

public class DeleteCustomer extends BaseClass{
	@Test
	public void DeleteCustomer() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[text()='Tasks']")).click();
		String customerName = exlib.exceldata("Customer", 1, 0);
		driver.findElement(By.xpath("//input[@placeholder='Quick search by name ...']")).sendKeys(customerName);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Test1']")).click();
		driver.findElement(By.xpath("//span[text()='Test1']/../../following-sibling::div[@class='editButton']")).click();
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='action']")));
		driver.findElement(By.xpath("//div[@class='action']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='deleteButton']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='submitBtn commitBtn greyButton']")).click();
	}
}
