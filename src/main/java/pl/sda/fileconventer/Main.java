package pl.sda.fileconventer;

public class Main {
    public static void main(String[] args) {

        Converter converter = new Converter();
        String sourceFilePath = "test.json";
        String sourceFilePath2= "test.csv";
        String sourceFilePath3= "testOut.xlsx";
        String outputFilePath = "testOut.xlsx";
        converter.convert(sourceFilePath, outputFilePath);
        converter.convert(sourceFilePath2, outputFilePath);
        converter.convert(sourceFilePath3, outputFilePath);
    }
}
