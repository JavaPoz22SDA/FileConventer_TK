package pl.sda.fileconventer;

import pl.sda.fileconventer.reader.*;
import pl.sda.fileconventer.writer.*;

public class Converter {
    public void convert(String sourceFilePath, String outputFilePath) {
        Reader reader = new ReaderFactory().produce(sourceFilePath);
        Writer writer = new WriterFactory().produce(outputFilePath);

        writer.write(outputFilePath, reader.read(sourceFilePath));

//        ReaderFactory readerFactory = new ReaderFactory();
//        WriterFactory writerFactory = new WriterFactory();
//        Reader reader = readerFactory.produce(sourceFilePath);
//        Writer writer = writerFactory.produce(outputFilePath);
//        if (reader instanceof JSONReader) {
//            System.out.println("Działa JSON");
//            System.out.println(reader.read(sourceFilePath));
//        } else if (reader instanceof CSVReader) {
//            System.out.println("Działa CSV");
//            System.out.println(reader.read(sourceFilePath));
//        } else if (reader instanceof ExcelReader) {
//            System.out.println("Działa Excel");
//            System.out.println(reader.read(sourceFilePath));
//        }
//
//        if (writer instanceof ExcelWriter) {
//            System.out.println("Działa Excel");
//            writer.write(outputFilePath, reader.read(sourceFilePath));
//        }
    }
}
