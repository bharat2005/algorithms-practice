import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a + b > n || a >= n || b >= n) {
                System.out.println("NO");
                continue;
            } else {
                System.out.println("YES");
            }

            // base 1..n for a
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();

            // b wins
            for (int i = a + 1; i <= b; i++) {
                System.out.print(i + " ");
            }

            // a wins
            for (int i = 1; i <= a; i++) {
                System.out.print(i + " ");
            }

            // draws
            for (int i = b + 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}