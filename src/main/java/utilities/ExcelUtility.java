package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

    public static String[][] readExcelData(String filePath) throws IOException {

        FileInputStream file = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(file);

        // Excel sheet
        var sheet = workbook.getSheetAt(0);

        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        String[][] data = new String[totalRows - 1][totalColumns];

        for (int i = 1; i < totalRows; i++) {

            for (int j = 0; j < totalColumns; j++) {

                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }

        workbook.close();
        file.close();

        return data;
    }
}