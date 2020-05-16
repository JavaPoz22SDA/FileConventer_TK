package pl.sda.fileconventer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ExcelWriter implements Writer {
    @Override
    public void write(String outputFilePath, List<Map<String, Object>> records) {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");
        int rowNumber = 1;
        int cellNumber = 0;
        Map<String, Object> header=records.get(0);

        Row rowHeader = sheet.createRow(0);
        for (Map.Entry<String, Object> entry : header.entrySet()) {
            rowHeader.createCell(cellNumber).setCellValue(entry.getKey());
            cellNumber++;
        }
        for (Map<String, Object> map : records) {
            Row row = sheet.createRow(rowNumber);
            cellNumber=0;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                row.createCell(cellNumber).setCellValue(entry.getValue().toString());
                cellNumber++;
            }
            rowNumber++;
        }
        try (OutputStream fileOut = new FileOutputStream(outputFilePath)) {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
