package com.krn.actitime.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import utils.ExcelUtils;

public class ExcelLib {
	public String exceldata(String sheetname, int rownum, int colnum) throws IOException {
		FileInputStream fl = new FileInputStream("C:\\Users\\Priya Raman\\eclipse-workspace\\Project\\Data\\Data.xlsx");
		Workbook workbook = new XSSFWorkbook(fl);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell column = row.getCell(colnum);
		String value = column.toString();
		workbook.close();
        fl.close();
		return value;
	}

}
