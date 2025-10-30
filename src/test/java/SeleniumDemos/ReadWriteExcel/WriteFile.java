package SeleniumDemos.ReadWriteExcel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class WriteFile {
    public static void main(String[] args) throws Exception {

        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\new_excel.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("S.No.");
        row1.createCell(1).setCellValue("Title");
        row1.createCell(2).setCellValue("Description");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("01");
        row2.createCell(1).setCellValue("Add data in cell");
        row2.createCell(2).setCellValue("Write an automation to add data in excel sheet");

        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("02");
        row3.createCell(1).setCellValue("Read data in cell");
        row3.createCell(2).setCellValue("Write an automation to read data in excel sheet");

        workbook.write(file);

        workbook.close();
        file.close();

        System.out.println("Created the excel file in the resources folder");

    }
}
