package pl.sda.fileconventer;

import java.util.List;
import java.util.Map;

public class WriterFactory  {

    Writer produce(String outputFilePath){
//        if(outputFilePath.endsWith(".json"))
//            return new JSONReader();
//        if(outputFilePath.endsWith(".csv"))
//            return new CSVReader();
        if(outputFilePath.endsWith(".xlsx"))
            return new ExcelWriter();
        return null;
    }

}
