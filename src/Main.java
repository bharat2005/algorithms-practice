import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                boolean[] set = new boolean[2 * n];

                // build left set
                for (int i = 0; i < c; i++) {
                    set[arr[r][i]] = true;
                }

                // build above set
                for (int i = 0; i < r; i++) {
                    set[arr[i][c]] = true;
                }

                // assign unused mex
                int mex = 0;
                while (set[mex]) {
                    mex++;
                }
                arr[r][c] = mex;
            }

            for (int x : arr[r]) {
                System.out.print(x + " ");
            }
        }
    }
}