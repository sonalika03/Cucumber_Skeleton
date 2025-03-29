package com.seleniumUtilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.LinkedList;

public class excelUtility {
    static File file = new File("C:\\Users\\2078007\\OneDrive - Cognizant\\Desktop\\New folder (9)\\Cucumber_Skeleton\\src\\test\\resources\\Properties\\ExcelUtility.xlsx");
    static FileInputStream inputStream;

    static {
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static LinkedList<String> header = new LinkedList<>();
    static LinkedList<String> footer = new LinkedList<>();

//    HSSFRow row = sheet.getRow(1);
static XSSFWorkbook excel;

    static {
        try {
            excel = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static DataFormatter df = new DataFormatter();


    public excelUtility() throws IOException {
    }
    public static void main(String[]args) throws IOException {
        excelUtility utility = new excelUtility();
        System.out.println(getCellData("Sheet1",5,"URL"));
    }

    public static LinkedList<String> getHeaders(String sheetName) throws IOException {
        XSSFSheet sheet = excel.getSheet(sheetName);
        XSSFRow row = sheet.getRow(0);
        for (Cell cell : row)
            header.add(String.valueOf(cell));
        return header;
    }


    public static String getCellData(String sheetName, int num, String columnName) throws IOException {
        XSSFSheet sheet = excel.getSheet(sheetName);
        int RowNum = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for (int i=0; i<=RowNum; i++) {
            if (i == num) {
                for (int j = 0; j <= getHeaders(sheetName).size(); j++) {
                    if (getHeaders(sheetName).get(j).equalsIgnoreCase(columnName)) {
                        return sheet.getRow(i).getCell(j).toString();
                    }
                }
            }
        }return"";
    }
}
