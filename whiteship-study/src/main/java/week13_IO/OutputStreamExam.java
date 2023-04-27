package week13_IO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class OutputStreamExam {

    public static void main(String[] args) throws IOException {
        byte[] byteData = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ByteArrayOutputStream os;

        Charset charset = Charset.defaultCharset();
        System.out.println("charset = " + charset);
        System.out.println("(int)'1' = " + (int) '1');

        // write(int b)
        System.out.println("============write(int b)============");
        os = new ByteArrayOutputStream();

        os.write('a');
        os.write('b');
        os.write('c');

        byte[] writtenByteData = os.toByteArray();

        for (byte writtenData : writtenByteData) {
            System.out.println("writtenData = " + (char) writtenData);
        }
        /**
         * writtenData = a
         * writtenData = b
         * writtenData = c
         */

        // write(byte[] b)
        System.out.println("============write(byte[] b)============");
        os = new ByteArrayOutputStream();

        os.write(byteData);

        writtenByteData = os.toByteArray();

        for (byte writtenData : writtenByteData) {
            System.out.println("writtenData = " + writtenData);
        }
        /**
         * writtenData = 0
         * writtenData = 1
         * writtenData = 2
         * writtenData = 3
         * writtenData = 4
         * writtenData = 5
         * writtenData = 6
         * writtenData = 7
         * writtenData = 8
         * writtenData = 9
         */

        // write(byte[] b, int off, int len)
        System.out.println("============write(byte[] b, int off, int len)============");
        os = new ByteArrayOutputStream();

        os.write(byteData, 5, 3);

        writtenByteData = os.toByteArray();

        for (byte writtenData : writtenByteData) {
            System.out.println("writtenData = " + writtenData);
        }
        /**
         * writtenData = 5
         * writtenData = 6
         * writtenData = 7
         */
    }
}
