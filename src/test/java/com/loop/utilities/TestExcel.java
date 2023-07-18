package com.loop.utilities;

public class TestExcel {
    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils("C:\\Users\\edurs\\OneDrive\\Desktop\\Book1.xlsx", "Sheet1");

        System.out.println("Data from excel = " + excelUtils.getCellData(7, 3));
    }
}
