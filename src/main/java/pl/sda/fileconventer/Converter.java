package pl.sda.fileconventer;

public class Converter {
    public void convert(String sourceFilePath,String outputFilePath){
ReaderFactory readerFactory=new ReaderFactory();
        Reader reader = readerFactory.produce(sourceFilePath);
        Reader reader2 = readerFactory.produce(sourceFilePath);
        Reader reader3 = readerFactory.produce(sourceFilePath);
       // reader.read(sourceFilePath);
        if(reader instanceof JSONReader) {
            System.out.println("Działa JSON");
            System.out.println(reader.read(sourceFilePath));
        }
        if(reader2 instanceof CSVReader) {
            System.out.println("Działa CSV");
            System.out.println(reader2.read(sourceFilePath));
        }
        if(reader3 instanceof ExcelReader) {
            System.out.println("Działa Excel");
            System.out.println(reader2.read(sourceFilePath));
        }
    }
}
