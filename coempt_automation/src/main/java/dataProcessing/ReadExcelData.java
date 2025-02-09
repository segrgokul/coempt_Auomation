package dataProcessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelData {

    public static Object[][] readExcelData() throws IOException {
        
        // Define the path to the Excel file
    	 String filePath = "D:\\Coempt_Automation\\coempt_automation\\src\\test\\resources\\dataSheets\\ResulProcess.xlsx";
         FileInputStream excelFile = new FileInputStream(filePath);

         try {
        // Initialize FileInputStream and Workbook
       
             XSSFWorkbook workbook = new XSSFWorkbook(excelFile);

            // Get the sheet by name
            XSSFSheet sheet = workbook.getSheet("mds");

          
            if (sheet == null) {
                throw new RuntimeException("Sheet not found in the workbook.");
            }
            
            // Get the row and column count
            int rowCount = sheet.getPhysicalNumberOfRows();
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

            // Prepare an Object array to store the data
            Object[][] data = new Object[rowCount - 1][columnCount];  // Exclude header row

            // Loop through rows and columns
            for (int i = 1; i < rowCount; i++) {  // Start from row 1 to skip the header
                Row row = sheet.getRow(i);
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = row.getCell(j);  // Get the cell at the specific row and column
                    
                    // Check if the cell is null
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                // If the cell contains a string, get the value and trim it
                                data[i - 1][j] = cell.getStringCellValue().trim();
                                break;

                            case NUMERIC:
                                // If the cell contains a number, check if it's an integer
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    // If the cell is a date, format as a string (optional)
                                    data[i - 1][j] = cell.getDateCellValue().toString();
                                } else {
                                    double numericValue = cell.getNumericCellValue();
                                    // Check if the numeric value is a whole number or has decimals
                                    if (numericValue == (int) numericValue) {
                                        data[i - 1][j] = String.valueOf((int) numericValue);  // Store as integer string
                                    } else {
                                        data[i - 1][j] = String.format("%.0f", numericValue);  // Format as string without decimals
                                    }
                                }
                                break;

                            case BOOLEAN:
                                // If the cell contains a boolean value
                                data[i - 1][j] = Boolean.toString(cell.getBooleanCellValue());
                                break;

                            case FORMULA:
                                // If the cell contains a formula, evaluate it
                                data[i - 1][j] = cell.getCellFormula();
                                break;

                            default:
                                data[i - 1][j] = "";  // If the cell type is not handled, store empty string
                                break;
                        }
                    }
                    
               
                    
                    else {
                        // If the cell is null, store a null value
                        data[i - 1][j] = null;
                    }
                }
            }

            return data;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error reading the Excel file.");
        }
    }
}
