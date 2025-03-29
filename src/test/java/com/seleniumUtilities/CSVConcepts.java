package com.seleniumUtilities;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVConcepts {
    public static void main(String[] args) throws IOException, CsvException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        csvReader(driver);
//        csvWriter();
        driver.quit();
    }

    public static void csvReader(WebDriver driver) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\2078007\\OneDrive - Cognizant\\Desktop\\New folder (9)\\Cucumber_Skeleton\\src\\test\\resources\\Properties\\csvParser.csv"));
//        List<String[]> values= reader.readAll();  // nameageclasssubject
        String[] values = reader.readNext();  // [name, age, class, subject]
            driver.findElement(By.id("firstName")).sendKeys(values[0]);
            driver.findElement(By.id("lastName")).sendKeys(values[1]);
            driver.findElement(By.id("userEmail")).sendKeys(values[2]);
            driver.findElement(By.xpath("//div[@id='userNumber-wrapper']/div[2]/input")).sendKeys(values[3]);
        driver.quit();
    }

    public static void csvWriter() throws IOException, CsvValidationException {
        CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\2078007\\OneDrive - Cognizant\\Desktop\\New folder (9)\\Cucumber_Skeleton\\src\\test\\resources\\Properties\\csvWriter.csv"));

        String[] row1 = {"Sam", "12", "Maths"};
        String[] row2 = {"Name", "Age", "Subject"};
        String[] row3 = {"Ram", "13", "Science"};
        String[] row4 = {"Anu", "14", "Hindi"};

        ArrayList<String[]> list = new ArrayList<>();
        list.add(0,row2);
        list.add(1,row1);
        list.add(2,row3);
        list.add(3,row4);

        writer.writeAll(list);
        writer.flush();

        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\2078007\\OneDrive - Cognizant\\Desktop\\New folder (9)\\Cucumber_Skeleton\\src\\test\\resources\\Properties\\csvWriter.csv"));
        String[] values;
        while ((values= reader.readNext())!=null) {
            for (String value : values) {
                System.out.println(value);
            }
        }
    }
}