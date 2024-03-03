package com.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class excelReader {
    String Projectpath = System.getProperty("user.dir")+"/src/test/resources/Properties/";
    String Path;
    ArrayList<String> line = new ArrayList<>();
    ArrayList<String> header = new ArrayList<>();
    ArrayList<String> footer = new ArrayList<>();
    XSSFWorkbook excel;
    XSSFSheet sheet;
    DataFormatter df = new DataFormatter();
    public excelReader(String excelName) throws IOException {
        Path = Projectpath+excelName;
        this.Projectpath = Path;
        excel = new XSSFWorkbook(Projectpath);

    }
    public HashMap getDataTable(String sheetName, String testCaseID) throws IOException {
        return setDatainMap(sheetName,getRowNum(sheetName, testCaseID));

    }
    public int getRowNum(String sheetName, String testCaseID){
        XSSFSheet sheet = excel.getSheet(sheetName);
        int rowNum = -1;
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (String.valueOf(cell).equalsIgnoreCase(testCaseID)) {
                    rowNum = row.getRowNum();
                }
            }
        }return rowNum;
    }

    public int getColumnNum(String sheetName, String columnName) throws IOException {
        ArrayList<String> columns = getHeaders(sheetName);
        int columnNum =0;
        for (int i=0;i<columns.size();i++){
        if(columns.get(i).equalsIgnoreCase(columnName)){
            columnNum =i;
        }
        }return columnNum;
        }

    public ArrayList getRowData(String sheetName, String testCaseID) throws IOException {
        ArrayList footers = getFooters(getRowNum(sheetName,testCaseID),sheetName);
        System.out.println(footers);
        return footers;
        }

    private HashMap setDatainMap(String sheetName, int row) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        getHeaders(sheetName);
        getFooters(row,sheetName);
        for (int i=0;i<header.size();i++){
            map.put(header.get(i),footer.get(i));
        }
        System.out.println(map);

    return map;
    }
    public ArrayList getHeaders(String sheetName) throws IOException {
        XSSFSheet sheet = excel.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            for (Cell cell :row)
                header.add(String.valueOf(cell));
            return header;
        }

    public ArrayList getFooters(int rowNum, String sheetName) throws IOException {
        XSSFSheet sheet = excel.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNum);
        for (Cell cell : row){
            if (cell.getCellType()== CellType.NUMERIC)
                footer.add(df.formatCellValue(cell));
            else
                footer.add(String.valueOf(cell));
        }return footer;

    }

    public static void main(String args[]) throws IOException {
        excelReader getExcel = new excelReader("ExcelData.xlsx");
        getExcel.getRowData("Sheet1","TC2");
                }
    }
