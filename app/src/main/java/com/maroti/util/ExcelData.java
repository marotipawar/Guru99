package com.maroti.util;

import org.apache.poi.ss.usermodel.CellReferenceType;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Spliterator;

public class ExcelData {

    public static void main(String[] args){

        File excelFile=new File("data","Users.xlsx");
        boolean isExit =excelFile.exists();
        System.out.println(isExit);
        try(FileInputStream readExcelFile = new FileInputStream(excelFile)) {

            XSSFWorkbook workbook = new XSSFWorkbook(readExcelFile);

            XSSFSheet sheet =workbook.getSheetAt(0);
            Spliterator<Row> rowIterator =sheet.spliterator();

            System.out.println("Estimated Size : "+rowIterator.estimateSize());
            System.out.println("Charastics : "+rowIterator.hasCharacteristics(rowIterator.characteristics()));

            rowIterator.forEachRemaining(row->{
                System.out.println("\n");
                row.forEach(e->{
                    if(e.getCellType().equals(CellType.NUMERIC)) {
                        System.out.print(e.getNumericCellValue()+ " ");
                    } if(e.getCellType().equals(CellType.STRING)) {
                        System.out.print(e.getStringCellValue()+ " ");
                    }
                    ;
                });
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
