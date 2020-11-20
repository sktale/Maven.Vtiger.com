package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataStorage {

	public static FileInputStream fis;
	public static Properties prop;
	public static FileOutputStream fos;

	public String getDataFromproperty(String key) throws IOException {
		fis = new FileInputStream("./src/main/resources/resourse/excel/data.properties");
		prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;

	}

	public static String getDataFromExcel(String sheetname, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream("./src/main/resources/resourse/excel/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Cell cel = book.getSheet(sheetname).getRow(rowNum).getCell(cellNum);

		String value = cel.getStringCellValue();
		return value;

	}

	public static void UpdateDatatoExcel(String sheetname, int rowNum, int cellNum, String newData) throws IOException {
		fis = new FileInputStream("./src/main/resources/resourse/excel/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Cell cel = book.getSheet(sheetname).getRow(rowNum).getCell(cellNum);
		cel.setCellValue(newData);
		fos = new FileOutputStream("./src/main/resources/resourse/excel/excel.xlsx");
		book.write(fos);
		fos.flush();

	}
	public void addNewCellDataInExcel(String sheetname, int rowNum, int cellNum, String newData) throws IOException
	{
		fis = new FileInputStream("./src/main/resources/resourse/excel/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Cell cel = book.createSheet(sheetname).createRow(rowNum).createCell(cellNum);
		cel.setCellValue(newData);
		fos = new FileOutputStream("./src/main/resources/resourse/excel/excel.xlsx");
		book.write(fos);
		fos.flush();
		
	}

}
