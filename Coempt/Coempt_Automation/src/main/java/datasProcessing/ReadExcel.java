package datasProcessing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class ReadExcel {
	 public static Object[][] readExcel(String filePath, String sheetName) throws InvalidFormatException, IOException {
	        // Open the file as a stream
	        FileInputStream file = new FileInputStream(filePath);

	        // Create a workbook instance for the Excel file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        // Access the desired sheet
	        XSSFSheet sheet = workbook.getSheet(sheetName);

	        // Get the total number of rows and columns
	        int rowCount = sheet.getLastRowNum();
	        int columnCount = sheet.getRow(0).getLastCellNum();

	        // Create an array to store the data
	        Object[][] data = new Object[rowCount][columnCount];

	        // Iterate through rows and columns to read cell data
	        for (int i = 1; i <= rowCount; i++) {
	            XSSFRow row = sheet.getRow(i);
	            for (int j = 0; j < columnCount; j++) {
	                XSSFCell cell = row.getCell(j);

	                // Use DataFormatter to fetch the cell value as a string
	                DataFormatter formatter = new DataFormatter();
	                String value = formatter.formatCellValue(cell);

	                // Store the value in the array
	                data[i - 1][j] = value;
	            }
	        }

//	        // Close the workbook and file stream
//	        workbook.close();
//	        file.close();

	        // Return the extracted data
	        return data;
	    }
}
