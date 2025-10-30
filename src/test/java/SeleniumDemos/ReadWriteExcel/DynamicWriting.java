package SeleniumDemos.ReadWriteExcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Scanner;

public class DynamicWriting {
    public static void main(String[] args) throws Exception {

        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Dynamic.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Dynamic");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows required:");
        int No_of_rows = sc.nextInt();

        System.out.println("Enter number of cells required:");
        int No_of_cells = sc.nextInt();

        for (int r = 0; r <= No_of_rows; r++) {
            XSSFRow currentRow = sheet.createRow(r);
            for (int c = 0; c <= No_of_cells; c++) {
                System.out.println("Enter value for Row " + r + ", Cell " + c + ": ");
                XSSFCell cell = currentRow.createCell(c);
                cell.setCellValue(sc.next());
            }
        }

        workbook.write(file);
        workbook.close();
        file.close();
        sc.close();

        System.out.println("File has been created successfully!");
    }
}
