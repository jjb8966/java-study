package week13_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {

    public static void main(String[] args) throws IOException {
        File fileA = new File("/Users/joojongbum/Desktop/input-file-a.txt");

        // 이름으로 파일 객체를 만들 경우, 작업 디렉토리 내에 해당 이름을 가진 파일이 존재해야 함
        File fileB = new File("input-file-b.txt");
        File fileC = new File("input-file-c.txt");

        // 애플리케이션 작업 디렉로리 확인
        System.out.println(System.getProperty("user.dir"));

        System.out.println("fileA.exists() = " + fileA.exists());
        System.out.println("fileB.exists() = " + fileB.exists());
        System.out.println("fileC.exists() = " + fileC.exists());
        /**
         * fileA.exists() = true
         * fileB.exists() = true
         * fileC.exists() = false
         */

        // fileA 읽어오기
        FileInputStream fis;
        int readData;

        fis = new FileInputStream(fileA);

        while ((readData = fis.read()) != -1) {
            System.out.println("readData = " + (char) readData);
        }
        /**
         * readData = i
         * readData = n
         * readData = p
         * readData = u
         * readData = t
         * readData =
         * readData = f
         * readData = i
         * readData = l
         * readData = e
         * readData =
         * readData = a
         * readData =
         */

        // fileB 읽어서 output-file-b 만들기
        fis = new FileInputStream(fileB);

        byte[] byteData = fis.readAllBytes();
        File outputFileB = new File("output-file-b.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileB);

        fileOutputStream.write(byteData);   // output-file-b.txt 파일이 작업 디렉토리에 없을 경우 파일 생성

        // output-file-b.txt 파일에 이어서 작성하기
        String appendExp = "\nappend data";
        byte[] appendData = appendExp.getBytes();

        // append false인 경우 파일을 덮어씀
        fileOutputStream = new FileOutputStream(outputFileB, true);
        fileOutputStream.write(appendData);
    }
}
