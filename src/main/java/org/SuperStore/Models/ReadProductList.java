package org.SuperStore.Models;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadProductList {
    private List<Product> products = new ArrayList<>();
    public void readListOfFromFile(String fileName) {
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workBook.getSheetAt(0);
            int rows = sheet.getLastRowNum();

            for (int r = 1; r < rows; r++) {
                XSSFRow row = sheet.getRow(r);
                String cell1 = row.getCell(0).getStringCellValue();
                String cell2 = row.getCell(1).getStringCellValue();
                Double cell3 = row.getCell(2).getNumericCellValue();
                int cell4 = (int) row.getCell(3).getNumericCellValue();
                Product product = new Product(cell1,cell2,cell3, cell4);
                products.add(product);
                workBook.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public List<Product> getProducts() {
        return products;
    }
}
