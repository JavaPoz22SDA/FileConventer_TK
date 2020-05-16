package pl.sda.fileconventer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelReader implements Reader {
    @Override
    public List<Map<String, Object>> read(String inputFilePath) {
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(inputFilePath));

            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.rowIterator();
            int size = (sheet.getRow(0).getPhysicalNumberOfCells());
            Row hederRow = sheet.getRow(0);

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                Map<String, Object> map = new HashMap<>();
                for (int i = 0; i < size; i++) {
                    map.put(hederRow.getCell(i).toString(), row.getCell(i));
                }
                result.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
