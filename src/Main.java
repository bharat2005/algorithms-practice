import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
            int[] second = new int[n];

            for (int i = 0; i < n; i++) {
                first[i] = i + 1;
            }

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
            for (int i = 0; i < k; i++) {
                second[i] = (i + b) % k + 1;
            }

            if (swapped) {
                int[] tmp = first;
                first = second;
                second = tmp;
            }

            System.out.println("YES");

            for (int i = 0; i < n; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(first[i]);
            }
            System.out.println();

            for (int i = 0; i < n; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(second[i]);
            }
            System.out.println();
        }
    }
}