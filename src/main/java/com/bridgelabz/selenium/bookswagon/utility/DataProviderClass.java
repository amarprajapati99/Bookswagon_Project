package com.bridgelabz.selenium.bookswagon.utility;

import com.bridgelabz.selenium.bookswagon.base.BaseClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class DataProviderClass extends BaseClass{

    String excelPath = "F:\\Selenium\\BooksWagon\\src\\main\\resources\\bookswagonLoginCredentials.xlsx";
    String sheetName = "Sheet1";

    @DataProvider (name = "testDataSetFromExcelFile")
    public  Object[][] getDataTest() throws IOException {
        File file = new File(excelPath);
        try {
            if (!file.exists()) {

                throw new CustomException(CustomException.ExceptionType.FILE_NOT_EXIST, "File not Exist Please check file path and file name");
            }
        } catch (CustomException exception) {

            System.out.println(exception.getMessage());
        }
        Object[][] data = ExcelDataProvider.testData(excelPath, sheetName);
        return data;
    }
}