package pl.sda.fileconventer;

public class ReaderFactory {
    public Reader produce(String filePath){

        if(filePath.endsWith(".json"))
            return new JSONReader();

        //TODO CSVReader, i ExcelReader
        return null;
    }
}
