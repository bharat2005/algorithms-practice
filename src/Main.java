import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= (int) Math.pow(2.0, n); i++) {
            int gray = i ^ (i >> 1);

            String s = Integer.toString(gray);

            while (s.length() < n) {
                s = "0" + s;
            }

            System.out.println(s);
        }
    }
}