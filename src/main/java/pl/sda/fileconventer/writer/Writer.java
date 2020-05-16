package pl.sda.fileconventer.writer;

import java.util.List;
import java.util.Map;

public interface Writer {
    void write(String outputFilePath, List<Map<String,Object>> records);
}
