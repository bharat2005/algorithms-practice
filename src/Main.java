import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // build union set
                boolean[] set = new boolean[2 * n];

                // left
                for (int x = 0; x < j; x++) {
                    set[grid[i][x]] = true;
                }

                // above
                for (int y = 0; y < j; y++) {
                    set[grid[y][j]] = true;
                }

                // check mex
                int mex = 0;
                while (set[mex]) {
                    mex++;
                }

                grid[i][j] = mex;
            }

            for (int value : grid[i]) {
                System.out.print(value + " ");
            }
        }
    }
}