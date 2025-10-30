package SeleniumDemos.ReadWriteExcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("s1");

        int totalRows = sheet.getLastRowNum();
        int totalColmns = sheet.getRow(1).getLastCellNum();

        System.out.println("Row count is :" + totalRows);
        System.out.println("Colums count is:" + totalColmns);


        for (int r = 0; r <= totalRows; r++) {
            XSSFRow currentRow = sheet.getRow(r);

                for (int c = 0; c < totalColmns; c++)
                {
                    XSSFCell cell = currentRow.getCell(c);

                        System.out.print(cell.toString() + "\t");
                }

        System.out.println();
            }
        workbook.close();
        file.close();
    }
}