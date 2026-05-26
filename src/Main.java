import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < (int) Math.pow(2.0, n); i++) {
            int gray = i ^ (i >> 1);

            String binary = Integer.toBinaryString(gray);
            while (binary.length() < n) {
                binary = "0" + binary;
            }

            System.out.println(binary);
        }
    }
}