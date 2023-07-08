package com.maroti.data;

import com.maroti.model.Guru99Register;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterExcelDataProvider {

    public static List<Guru99Register> getExcelData() throws FileNotFoundException {

        List<Guru99Register> registers=null;

        try(FileInputStream readExcelFile = new FileInputStream(new File("data", "RegisterData.xlsx")) ) {

            XSSFWorkbook workbook = new XSSFWorkbook(readExcelFile);
            XSSFSheet sheet =workbook.getSheetAt(0);
            int rowSize=sheet.getLastRowNum();
            registers=new ArrayList<>();
            for(int r=1; r<rowSize; r++){
                XSSFRow row =sheet.getRow(r);
                Guru99Register register = new Guru99Register();
                register.setFirstName(row.getCell(0).toString());
                register.setLastName(row.getCell(1).toString());
                register.setPhone(row.getCell(3).toString());
                register.setEmail(row.getCell(2).toString());
                register.setAddress(row.getCell(4).toString());
                register.setCity(row.getCell(5).toString());
                register.setState(row.getCell(6).toString());
                register.setCountry(row.getCell(7).toString());
                register.setPinCode(row.getCell(8).toString());
                register.setUserName(row.getCell(9).toString());
                register.setPassword(row.getCell(10).toString());
                register.setComfirmPassword(row.getCell(11).toString());
                registers.add(register);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return registers;
    }

  /* public static void main(String[] args) throws FileNotFoundException {
        getExcelData().forEach(reg->{
            System.out.println(reg.getCountry());
        });
    }*/
}
