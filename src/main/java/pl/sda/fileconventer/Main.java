package pl.sda.fileconventer;

public class Main {
    public static void main(String[] args) {

        Converter converter = new Converter();
        //String sourceFilePath = "test.json";
        String sourceFilePath= "test.csv";
        //String sourceFilePath= "testOut.xlsx";

        //String outputFilePath = "testOut.xlsx";
        String outputFilePath = "testOut.json";
        //String outputFilePath= "testOut.csv";

        converter.convert(sourceFilePath, outputFilePath);
    }
}
