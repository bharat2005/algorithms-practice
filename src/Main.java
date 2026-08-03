import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] grid = new char[m][];
        for (int i = 0; i < m; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char current = grid[i][j];
                if ((i + j) % 2 == 0) {
                    grid[i][j] = (current == 'A') ? 'B' : 'A';
                } else {
                    grid[i][j] = (current == 'C') ? 'D' : 'C';
                }
            }

            for (int j = 0; j < n; j++) {
                out.append(grid[i][j]);
            }
            out.append('\n');
        }

        System.out.print(out);
    }
}