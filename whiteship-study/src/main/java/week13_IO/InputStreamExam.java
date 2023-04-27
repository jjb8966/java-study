package week13_IO;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class InputStreamExam {

    public static void main(String[] args) throws IOException {
        byte[] byteData = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ByteArrayInputStream is;
        int readData;
        int numberOfReadData;

        // read()
        System.out.println("============read()============");
        is = new ByteArrayInputStream(byteData);

        while ((readData = is.read()) != -1) {
            System.out.println("readData = " + readData);
        }
        /**
         * readData = 0
         * readData = 1
         * readData = 2
         * readData = 3
         * readData = 4
         * readData = 5
         * readData = 6
         * readData = 7
         * readData = 8
         * readData = 9
         */

        // read(byte[] b)
        System.out.println("============read(byte[] b)============");
        is = new ByteArrayInputStream(byteData);

        byte[] buffer = new byte[3];

        while ((numberOfReadData = is.read(buffer)) != -1) {
            System.out.println("numberOfReadData = " + numberOfReadData);

            // 읽은 데이터의 갯수를 고려해서 출력
            for (int count = 0; count < numberOfReadData; count++) {
                System.out.println("data = " + buffer[count]);
            }
        }
        /**
         * numberOfReadData = 3
         * data = 0
         * data = 1
         * data = 2
         * numberOfReadData = 3
         * data = 3
         * data = 4
         * data = 5
         * numberOfReadData = 3
         * data = 6
         * data = 7
         * data = 8
         * numberOfReadData = 1
         * data = 9
         */

        // read(byte[] b, int off, int len)
        System.out.println("============read(byte[] b, int off, int len)============");
        is = new ByteArrayInputStream(byteData);

        byte[] bytes = new byte[5];

        numberOfReadData = is.read(bytes, 2, 3);

        System.out.println("numberOfReadData = " + numberOfReadData);

        for (byte data : bytes) {
            System.out.println("data = " + data);
        }
        /**
         * numberOfReadData = 3
         * data = 0
         * data = 0
         * data = 0
         * data = 1
         * data = 2
         */
    }
}
