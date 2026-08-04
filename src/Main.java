import java.io.*;

public class Main {

    static String path;
    static int n;
    static int ans = 0;
    static boolean[][] grid = new boolean[7][7];

    static boolean isblock(int r, int c) {
        // out of grid
        if (r < 0 || r >= 7 || c < 0 || c >= 7) return true;

        // already visited
        return grid[r][c];
    }

    static void dfs(int r, int c, int step) {

        // base case
        // reached
        if (r == 0 && c == 6 && step == n) {
            ans++;
            return;
        }

        // incorrect path
        if (step == n) return;

        // pruning
        // horizontal split
        if (isblock(r - 1, c) && isblock(r + 1, c) && !isblock(r, c - 1) && !isblock(r, c + 1)) return;

        // vertical split
        if (!isblock(r - 1, c) && !isblock(r + 1, c) && isblock(r, c - 1) && isblock(r, c + 1)) return;

        // mark visited
        grid[r][c] = true;

        // try further path
        if (path.charAt(step) != '?') {

            // try particular dir
            switch (path.charAt(step)) {
                case 'U':
                    if (!isblock(r - 1, c)) {
                        dfs(r - 1, c, step + 1);
                    }
                    break;

                case 'D':
                    if (!isblock(r + 1, c)) {
                        dfs(r + 1, c, step + 1);
                    }
                    break;

                case 'R':
                    if (!isblock(r, c + 1)) {
                        dfs(r, c + 1, step + 1);
                    }
                    break;

                case 'L':
                    if (!isblock(r, c - 1)) {
                        dfs(r, c - 1, step + 1);
                    }
                    break;
            }

        } else
        {

            // try all dir
            if (!isblock(r - 1, c)) {
                dfs(r - 1, c, step + 1);
            }
            if (!isblock(r + 1, c)) {
                dfs(r + 1, c, step + 1);
            }
            if (!isblock(r, c + 1)) {
                dfs(r, c + 1, step + 1);
            }
            if (!isblock(r, c - 1)) {
                dfs(r, c - 1, step + 1);
            }
        }

        //unmark visited
        grid[r][c] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        path = br.readLine();
        n = path.length();

        dfs(0, 0, 0);

        System.out.println(ans);
    }
}