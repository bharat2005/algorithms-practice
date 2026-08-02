import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int m = fs.nextInt();
        int n = fs.nextInt();

        char[][] grid = new char[m][];
        for (int i = 0; i < m; i++) {
            grid[i] = fs.next().toCharArray();
        }

        char[] charArr = {'A', 'B', 'C', 'D'};

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char curr = grid[i][j];
                char top = (i - 1 >= 0 && i - 1 < m) ? grid[i - 1][j] : curr;
                char left = (j - 1 >= 0 && j - 1 < n) ? grid[i][j - 1] : curr;

                int x = 0;
                while (charArr[x] != curr && charArr[x] != top && charArr[x] != left) x++;

                grid[i][j] = charArr[x];
            }

            for (int j = 0; j < n; j++) {
                if (j > 0) out.append(' ');
                out.append(grid[i][j]);
            }
            out.append('\n');
        }


    }
}