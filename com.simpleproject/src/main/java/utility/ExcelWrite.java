package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class ExcelWrite {

	

	//so when run in parallel only 1 thread will write into the file at a time

public static synchronized void writeDataIntoExcelFile(
        String fullname, String email, String password) throws IOException {

    String filePath = System.getProperty("user.home") + Constants.filepath;
    File file = new File(filePath);

    Workbook workbook;

    if (file.exists()) {
        try (FileInputStream fis = new FileInputStream(file)) {
            workbook = new XSSFWorkbook(fis);
        }
    } else {
        workbook = new XSSFWorkbook();
    }

    try {
       
    	 Sheet sheet = workbook.getSheet("Registered Users");

         if (sheet == null) {
             sheet = workbook.createSheet("Registered Users");

             Row header = sheet.createRow(0);
             header.createCell(0).setCellValue("Fullname");
             header.createCell(1).setCellValue("Email");
             header.createCell(2).setCellValue("Password");
         }

         int lastRow = sheet.getLastRowNum();
         Row row = sheet.createRow(lastRow + 1);

         row.createCell(0).setCellValue(fullname);
         row.createCell(1).setCellValue(email);
         row.createCell(2).setCellValue(password);

         try (FileOutputStream fos = new FileOutputStream(filePath)) {
             workbook.write(fos);
         }

         System.out.println("User data saved to Excel: " + email);

     }
    catch (IOException e) {
         e.printStackTrace();
     }
    
    finally {
        workbook.close();
    }
    }

}


