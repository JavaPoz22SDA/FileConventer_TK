package pl.sda.fileconventer.writer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class JSONWriter implements Writer {
    private Path path;

    @Override
    public void write(String outputFilePath, List<Map<String, Object>> records) {
        try {
            FileWriter fileWriter = new FileWriter(outputFilePath);
            JSONArray jsonArray = new JSONArray();
            for (Map<String, Object> map : records) {
                JSONObject content = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    content.put(entry.getKey(), entry.getValue());
                }
                jsonArray.put(content);
            }
            fileWriter.write(jsonArray.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
