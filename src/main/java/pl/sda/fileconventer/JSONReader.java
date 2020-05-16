package pl.sda.fileconventer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONReader implements Reader{

    private Path path;

    @Override
    public List<Map<String, Object>> read(String inputFilePath) {
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            path= Paths.get(inputFilePath);
            byte[] bytes = Files.readAllBytes(path);
           // System.out.println(bytes);
            String content=new String(bytes);
            //System.out.println(content);

            JSONArray jsonArray=new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                Object rawObject=jsonArray.get(i);
                JSONObject record = new JSONObject(rawObject.toString());
                Map<String,Object> map = new HashMap<>();
                for (String key:record.keySet()){
                    map.put(key, (Object) record.get(key));
                }
                result.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
