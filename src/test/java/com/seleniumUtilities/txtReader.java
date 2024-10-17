package com.seleniumUtilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;

public class txtReader {
    String[] headers = null;
    String[] footers = null;
    LinkedHashMap<String,String> Map;
    String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\";
    public txtReader(String Path){
        String tempPath = filePath + Path;
        this.filePath = tempPath;
    }
    public LinkedHashMap<String, String> getDataInMap(){
        Map = new LinkedHashMap<>();
        headers = getDataFromRow(0);
        footers = getDataFromRow(1);
        for (int i=1;i<headers.length;i++){
            Map.put(headers[i],footers[i]);
        }return Map;
    }
    public String[] getDataFromRow(int RowNum) {
        String dataInFile;
        BufferedReader br = null;
        String[] tempData = null;
        int count = 0;
        {
            try {
                br = new BufferedReader(new FileReader(filePath));
                while ((dataInFile = br.readLine()) != null) {
                    Pattern pattern = Pattern.compile("\\|");
                    if (count == RowNum) {
                        tempData= pattern.split(dataInFile);
                    }count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }return tempData;

    }
}