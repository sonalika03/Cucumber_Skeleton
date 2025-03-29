package com.seleniumUtilities;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class excelConcepts {
    public static void main(String[] args) throws IOException {
        excelWriter();
    }
    public static void excelReader() throws IOException {
        File file = new File("C:\\Users\\2078007\\OneDrive - Cognizant\\Desktop\\New folder (9)\\Cucumber_Skeleton\\src\\test\\resources\\Properties\\ExcelReader.xlsx");
        FileInputStream ip = new FileInputStream(file);
        ArrayList<String> list = new ArrayList<>();
        XSSFWorkbook wb = new XSSFWorkbook(ip);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int getRowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        System.out.println(getRowCount);
        for (int i = 0; i<=getRowCount; i++){
            XSSFRow row = sheet.getRow(i);
            int getCellCount = row.getLastCellNum() - row.getFirstCellNum();
            for (int j = 0; j<getCellCount; j++){
                XSSFCell cell = row.getCell(j);
                list.add(j, cell.toString());
            }
        }
        System.out.println(list);
        wb.close();
    }

    public static void excelWriter() throws IOException {
        File file = new File("C:\\Users\\2078007\\OneDrive - Cognizant\\Desktop\\New folder (9)\\Cucumber_Skeleton\\src\\test\\resources\\Properties\\ExcelReader.xlsx");
        FileInputStream fileInputStream= new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0);
        // wb.createSheet();   (To create sheet)
        // sheet.createRow(); (To create row)
        int LastCellNum = row.getLastCellNum();
        XSSFCell cell = row.createCell(LastCellNum);
        cell.setCellValue("Status");
        int rowCount = sheet.getLastRowNum() -sheet.getFirstRowNum();
        for (int i=1; i<=rowCount; i++) {
            XSSFRow rows = sheet.getRow(i);
            XSSFCell cells = rows.createCell(LastCellNum);
            cells.setCellValue("PASS");
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        wb.write(outputStream);
        wb.close();
    }
}