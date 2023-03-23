package week9_exception.try_with_resource;

import java.io.*;

public class TryWithResource {

    void originMethod() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("hi");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("반드시 실행되어야 하므로 finally에 작성");
            bw.close();
            br.close();
        }
    }

    void useTryWithResource() {
        try (
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("hi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
