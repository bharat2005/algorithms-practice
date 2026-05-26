import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < (int) Math.pow(2.0, n); i++) {
            int gray = i ^ (i >> 1);
            StringBuilder str = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (((gray >> j) & 1) == 1) {
                    str.append("1");
                } else {
                    str.append("0");
                }
            }

            System.out.println(str.toString());
        }
    }
}