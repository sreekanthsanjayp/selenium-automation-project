package com.krn.actitime.testbase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public ExcelLib exlib;
	@BeforeClass
	public void openBrowser() {
		//System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://online.actitime.com/ssanjay/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("Browser is open");
	}
	
	@BeforeMethod
	public void login() throws IOException {
		exlib = new ExcelLib();
		String un = exlib.exceldata("Login", 1, 0);
		String pwd = exlib.exceldata("Login", 1, 1);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("User Logged in");
	}
	
	@AfterMethod
	public void logout(){
		driver.findElement(By.xpath("//div[@class='pages-navigation-Popups-ProfilePopup-buttonsGroup--dKHJND4D'][1]")).click();
		driver.findElement(By.xpath("//div[text()='Logout']")).click();
		System.out.println("User Logged out");
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
		System.out.println("Browser is closed");
	}
}
