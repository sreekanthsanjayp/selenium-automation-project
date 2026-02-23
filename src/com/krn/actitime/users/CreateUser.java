package com.krn.actitime.users;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.BaseClass;

public class CreateUser extends BaseClass {
	@Test
	public void CreateUser() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//div[text()='New User']")).click();
		Thread.sleep(4000);
		String fname = exlib.exceldata("User", 1, 0);
		String lname = exlib.exceldata("User", 1, 1);
		String emailid = exlib.exceldata("User", 1, 2);
		driver.findElement(By.xpath("//input[@id='createUserPanel_firstNameField']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id='createUserPanel_lastNameField']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id='createUserPanel_emailField']")).sendKeys(emailid);
		driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
		driver.findElement(By.xpath("//span[text()='Close']")).click();
	}
}
