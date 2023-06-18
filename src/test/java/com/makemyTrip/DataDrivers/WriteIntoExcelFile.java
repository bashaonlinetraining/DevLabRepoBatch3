package com.makemyTrip.DataDrivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteIntoExcelFile {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();

		// spreadsheet object
		XSSFSheet spreadsheet = workbook.createSheet(" Student Data File2 ");

		// creating a row object
		XSSFRow row;

		// This data needs to be written (Object[])
		Map<String, Object[]> studentData = new TreeMap<String, Object[]>();

		studentData.put("1", new String[] { "Roll No", "NAME", "Year", "Age" });

		studentData.put("2", new String[] { "128", "Aditya", "2nd year", "20" });

		studentData.put("3", new String[] { "129", "Narayana", "2nd year", "19" });

		studentData.put("4", new String[] { "130", "Mohan", "2nd year", "24" });

		studentData.put("5", new String[] { "131", "Radha", "2nd year", "26" });

		studentData.put("6", new String[] { "132", "Gopal", "2nd year", "20" });

		Set<String> keyid = studentData.keySet();

		int rowid = 0;

		// writing the data into the sheets...

		for (String key : keyid) {

			row = spreadsheet.createRow(rowid++);
			String[] objectArr = (String[]) studentData.get(key);
			int cellid = 0;

			for (String obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue(obj);
			}
		}

		// .xlsx is the format for Excel Sheets...
		// writing the workbook into the file...
		FileOutputStream out = new FileOutputStream(new File("C:\\Tutorials\\Axyya\\Book2.xlsx"));

		workbook.write(out);
		out.close();
		System.out.println("Success.....");
	}

}
