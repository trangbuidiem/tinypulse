package trangbui.selenium.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    private TestUtils() {}

    public static Object[][] readTestData(String sheetName) {
        try {
            FileInputStream testDataFile = new FileInputStream(new Resources().getTEST_DATA_PATH());
            try {
                workbook = WorkbookFactory.create(testDataFile);
                sheet = workbook.getSheet(sheetName);
            } catch (IOException e) {
                Log.error(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            Log.error(e.getMessage());
        }
        int maxRow = sheet.getLastRowNum();
        int maxCol = sheet.getRow(0).getLastCellNum();
        Object[][] testData = new Object[maxRow][maxCol];
        for(int row=0; row<maxRow; row++) {
            for(int col=0; col<maxCol; col++ ) {
                testData[row][col] = sheet.getRow(row + 1).getCell(col).toString();
            }
        }
        return testData;
    }

    public static void printTestData(String sheetName) {
        Object[][] testData = readTestData(sheetName);
        int maxRow = testData.length;
        int maxCol = testData[0].length;
        Log.startSection("TEST DATA: " + sheetName);
        for(int row=0; row<maxRow; row++) {
            String rowValue ="";
            for(int col=0; col<maxCol; col++ ) {
                String cellValue = testData[row][col].toString();
                rowValue += StringUtils.rightPad(cellValue, 10);
            }
            Log.info(rowValue);
        }
    }
}
