package com.krn.actitime.users;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.BaseClass;

public class DeleteUser extends BaseClass{
	@Test
	public void DeleteUser() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//table[@class='userNameSelectorsTable']/div/div[3]")).click();
		driver.findElement(By.xpath("//div[@class='lensIcon']/following-sibling::input[@type='text']")).sendKeys("Sreekanth Sanjay");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Sreekanth']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='DELETE']")).click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
	}
}
