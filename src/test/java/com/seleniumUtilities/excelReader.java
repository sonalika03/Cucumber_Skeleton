package com.seleniumUtilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class excelReader {
    String Projectpath = System.getProperty("user.dir") + "/src/test/resources/Properties/";
    String Path;
    LinkedList<String> header = new LinkedList<>();
    LinkedList<String> footer = new LinkedList<>();
    XSSFWorkbook excel;
    XSSFSheet sheet;
    DataFormatter df = new DataFormatter();

    public excelReader(String excelName) throws IOException {
        Path = Projectpath + excelName;
        this.Projectpath = Path;
//        FileInputStream fis = new FileInputStream(Projectpath);
        excel = new XSSFWorkbook(new FileInputStream(Projectpath));

    }

    public LinkedHashMap getDataTable(String sheetName, String testCaseID) throws IOException {
        return setDatainMap(sheetName, getRowNum(sheetName, testCaseID));

    }

    public int getRowNum(String sheetName, String testCaseID) {
        XSSFSheet sheet = excel.getSheet(sheetName);
        int rowNum = -1;
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (String.valueOf(cell).equalsIgnoreCase(testCaseID)) {
                    rowNum = row.getRowNum();
                }
            }
        }
        return rowNum;
    }

    public int getColumnNum(String sheetName, String columnName) throws IOException {
        LinkedList<String> columns = getHeaders(sheetName);
        int columnNum = 0;
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i).equalsIgnoreCase(columnName)) {
                columnNum = i;
            }
        }
        return columnNum;
    }

    public LinkedList getRowData(String sheetName, String testCaseID) throws IOException {
        LinkedList footers = getFooters(getRowNum(sheetName, testCaseID), sheetName);
        System.out.println(footers);
        return footers;
    }

    private LinkedHashMap setDatainMap(String sheetName, int row) throws IOException {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        LinkedList<String> headers = getHeaders(sheetName);
        LinkedList<String> footers = getFooters(row, sheetName);
        for (int i = 0; i < headers.size(); i++) {
            try {
                map.put(headers.get(i), footers.get(i));
            } catch (Exception e) {
                System.out.println("OutofBound");
            }
        }
        System.out.println(map);

        return map;
    }

    public LinkedList<String> getHeaders(String sheetName) throws IOException {
        XSSFSheet sheet = excel.getSheet(sheetName);
        XSSFRow row = sheet.getRow(0);
        for (Cell cell : row)
            header.add(String.valueOf(cell));
        return header;
    }

    public LinkedList getFooters(int rowNum, String sheetName) throws IOException {
        XSSFSheet sheet = excel.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNum);
        for (Cell cell : row) {
            if (cell.getCellType() == CellType.NUMERIC)
                footer.add(df.formatCellValue(cell));
            else
                footer.add(String.valueOf(cell));
        }
        return footer;

    }

    public void setDataToExistingExcel(String sheetName, String testCaseID) throws IOException {
        XSSFSheet sheet = excel.getSheet(sheetName);
        int columnNum = getColumnNum(sheetName, "Status");
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            Cell cell = row.createCell(columnNum);
            cell.setCellValue("pass");
            FileOutputStream fos = new FileOutputStream(Path);
            excel.write(fos);
            fos.close();
        }

//        }
//        getColumnNum(sheetName, "Status");
//        getRowNum(sheetName, testCaseID);
//
//        System.out.println(setDataInMap);

//
    }

    public static void main(String args[]) throws IOException {
        excelReader getExcel = new excelReader("ExcelWrite.xlsx");
        getExcel.setDataToExistingExcel("Sheet1","TC1");


    }
}



