package pl.sda.fileconventer.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CSVWriter implements Writer {
    @Override
    public void write(String outputFilePath, List<Map<String, Object>> records) {
        try {
            FileWriter fileWriter = new FileWriter(outputFilePath);
            StringBuilder builder = new StringBuilder();
            //header
            Map<String, Object> header = records.get(0);
            for (Map.Entry<String, Object> entry : header.entrySet()) {
                builder.append(entry.getKey() + ";");
            }
            builder.deleteCharAt(builder.lastIndexOf(";")).append("\n");

            for (Map<String, Object> map : records) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    builder.append(entry.getValue() + ";");
                }
                builder.deleteCharAt(builder.lastIndexOf(";")).append("\n");
            }
            fileWriter.write(builder.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
