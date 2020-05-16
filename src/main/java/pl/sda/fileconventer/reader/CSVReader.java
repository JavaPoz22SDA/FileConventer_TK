package pl.sda.fileconventer.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader implements Reader {
    private Path path;

    @Override
    public List<Map<String, Object>> read(String inputFilePath) {
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            path = Paths.get(inputFilePath);
            byte[] bytes = Files.readAllBytes(path);
            String[] dataArray = new String(bytes).split("\r\n");

            List<String> dataList = new ArrayList<>(Arrays.asList(dataArray));
            List<String> hedersList = Arrays.asList(dataList.get(0).split(";"));
            dataList.remove(0);

            for (int i = 0; i < dataList.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                for (int j = 0; j < hedersList.size(); j++) {
                    String[] lineArray = dataList.get(i).split(";");
                    map.put(hedersList.get(j), lineArray[j]);
                }
                result.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
