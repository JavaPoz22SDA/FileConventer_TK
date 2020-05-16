package pl.sda.fileconventer;

public class Converter {
    public void convert(String sourceFilePath,String outputFilePath){
ReaderFactory readerFactory=new ReaderFactory();
        Reader reader = readerFactory.produce(sourceFilePath);
        reader.read(sourceFilePath);
        if(reader instanceof JSONReader) {
            System.out.println("Działa JSON");
            System.out.println(reader.read(sourceFilePath));
        }
    }
}
