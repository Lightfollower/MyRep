package lesson_3;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

public class FileOperator {

    public static void arrayToConsole() {
        try (FileInputStream fileInputStream = new FileInputStream("src/resources/lesson_3/source0.txt")) {
            byte[] bytes = fileInputStream.readAllBytes();
            for (byte b :
                    bytes) {
                //Вывожу байты, т.к. в задании ни слова про текст нет.
                System.out.print(b + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sewFiles(FileInputStream... fileInputStreams) {

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/resources/lesson_3/datafile.txt"))) {

            List<FileInputStream> streams = Arrays.asList(fileInputStreams);
            Enumeration<FileInputStream> enumeration = Collections.enumeration(streams);
            SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
                try {
                    bufferedOutputStream.write(sequenceInputStream.readAllBytes());
                    sequenceInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        arrayToConsole();
        try {
            FileInputStream[] fileInputStreams = {
                    new FileInputStream("src/resources/lesson_3/source1.txt"),
                    new FileInputStream("src/resources/lesson_3/source2.txt"),
                    new FileInputStream("src/resources/lesson_3/source3.txt"),
                    new FileInputStream("src/resources/lesson_3/source4.txt"),
                    new FileInputStream("src/resources/lesson_3/source5.txt")
            };
            sewFiles(fileInputStreams);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
