package com.maroti.data;


import com.maroti.model.User;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class ExcelDataProvider {

    public static List<User> readExcelData(String fileName) throws FileNotFoundException {
        List<User> users = null;
        try (FileInputStream readFile = new FileInputStream(new File("data", fileName))) {
            XSSFWorkbook workbook = new XSSFWorkbook(readFile);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowSize = sheet.getLastRowNum();
            System.out.println("RowSize :" + rowSize);

            int cellSize = sheet.getRow(0).getLastCellNum();
            System.out.println("Cell size : " + cellSize);
            users = new ArrayList<>();
            for (int r = 0; r < rowSize; r++) {
                XSSFRow row = sheet.getRow(r);

                String firstName = row.getCell(1).toString();
                String lastName = row.getCell(2).toString();
                String email = row.getCell(3).toString();
                String gender = row.getCell(4).toString();
                String zipCode = row.getCell(5).toString();

                User user = new User();

                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setGender(gender);
                user.setZipCode(zipCode);
                users.add(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

}
