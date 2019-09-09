package java.lesson_3;

import java.io.*;

public class StreamTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (StackTraceElement element:
                Thread.currentThread().getStackTrace()) {
                    System.out.println(element);
                }

            }
        }).start();
        try {
            FileWriter fileWriter = new FileWriter("testfile.txt");
//
            FileOutputStream fileoutputStream = new FileOutputStream("testfile.txt");

//            fileWriter.write("ЙDF");
            fileoutputStream.write(-2);
            fileoutputStream.write(-1);
            fileoutputStream.write(-1);
//            System.out.println(fileInputStream.read());
//            fileWriter.close();
            fileoutputStream.close();
//            FileReader fileReader = new FileReader("testfile.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            System.out.println(fileReader.read());
//            System.out.println((int) fileReader.read());

            FileInputStream fileInputStream = new FileInputStream("testfile.txt");
            System.out.println(fileInputStream.read());
            System.out.println(fileInputStream.read());
            System.out.println(fileInputStream.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
