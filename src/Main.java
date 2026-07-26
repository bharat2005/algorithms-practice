import java.io.*;
import java.util.*;

public class Main {

    private static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int a = fs.nextInt();
            int b = fs.nextInt();

            if (a + b > n || Math.max(a, b) == n) {
                System.out.println("NO");
                continue;
            }

            int[] first = new int[n];
            for (int i = 0; i < n; i++) {
                first[i] = i + 1;
            }

            int[] second = new int[n];

            boolean swapped = false;
            if (a < b) {
                swapped = true;
                int tmp = a;
                a = b;
                b = tmp;
            }

            // Draws
            for (int i = a + b; i < n; i++) {
                second[i] = i + 1;
            }

            // Rotation on first (a+b) positions
            int k = a + b;
            for (int i = 1; i <= k; i++) {
                int u = (i - b + k) % k;
                if (u == 0) {
                    u = k;
                }
                second[i - 1] = u;
            }

            if (swapped) {
                int[] tmp = first;
                first = second;
                second = tmp;
            }

            System.out.println("YES");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(' ');
                sb.append(first[i]);
            }
            System.out.println(sb);

            sb.setLength(0);
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(' ');
                sb.append(second[i]);
            }
            System.out.println(sb);
        }
    }
}