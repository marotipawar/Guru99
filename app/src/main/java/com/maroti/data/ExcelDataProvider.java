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
            users = new ArrayList<>();
            for (int r = 0; r < rowSize; r++) {

                XSSFRow row = sheet.getRow(r);

                User user = new User();
                user.setFirstName(row.getCell(1).toString());
                user.setLastName(row.getCell(2).toString());
                user.setEmail(row.getCell(3).toString());
                user.setGender(row.getCell(4).toString());
                user.setZipCode(row.getCell(5).toString());
                users.add(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

}
