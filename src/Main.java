import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        int nextInt() throws Exception {
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

            if (a + b > n || (Math.min(a, b) == 0 && Math.max(a, b) != 0)) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");

            // Player 1
            for (int i = 1; i <= n; i++) {
                if (i > 1) System.out.print(" ");
                System.out.print(i);
            }
            System.out.println();

            // Player 2
            int[] ans = new int[n];

            int idx = 0;

            // Bob wins (player 2 wins)
            for (int x = a + 1; x <= a + b; x++) {
                ans[idx] = x;
                idx++;
            }

            // Alice wins (player 1 wins)
            for (int x = 1; x <= a; x++) {
                ans[idx] = x;
                idx++;
            }

            // Draws
            for (int x = a + b + 1; x <= n; x++) {
                ans[idx] = x;
                idx++;
            }

            boolean ok = true;

            for (int i = 0; i < n; i++) {
                if (i + 1 > ans[i]) {
                    a--;
                } else if (i + 1 < ans[i]) {
                    b--;
                }
            }

            if (a != 0 || b != 0) {
                System.out.println("NO");
            } else {
                for (int i = 0; i < n; i++) {
                    if (i > 0) System.out.print(" ");
                    System.out.print(ans[i]);
                }
                System.out.println();
            }
        }
    }
}