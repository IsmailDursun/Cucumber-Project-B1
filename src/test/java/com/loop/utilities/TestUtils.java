package com.loop.utilities;

public class TestUtils {

    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils("/Users/nsh/Library/Containers/com.microsoft.Excel/Data/Desktop/Book1.xlsx", "Sheet1");
        System.out.println("excelUtils.getCellData(0,0) = " + excelUtils.getCellData(0, 0));
    }
}
