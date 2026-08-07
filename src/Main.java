import java.io.*;

public class Main {

    static String paths;
    static boolean[][] visited = new boolean[7][7];
    static int res = 0;

    static char[] dir = {'U', 'D', 'L', 'R'};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean isBlocked(int row, int column) {
        // out of bound or already visited
        return row < 0 || row > 6 || column < 0 || column > 6 || visited[row][column];
    }

    static void dfs(int r, int c, int step) {

        // base cases
        // reached desired end
        if (r == 6 && c == 0 && step == 48) {
            res++;
            return;
        }

        // reached at wrong end
        if (step == 48) return;

        visited[r][c] = true;

        // pruning cases

        // i) reaching too early
        if (r == 6 && c == 0) {
            visited[r][c] = false;
            return;
        }

        // ii) future failer cases

        // -horizontal closure
        if (isBlocked(r - 1, c)
                && isBlocked(r + 1, c)
                && !isBlocked(r, c - 1)
                && !isBlocked(r, c + 1)) {
            visited[r][c] = false;
            return;
        }

        // -vertical closure
        if (isBlocked(r, c - 1)
                && isBlocked(r, c + 1)
                && !isBlocked(r + 1, c)
                && !isBlocked(r - 1, c)) {
            visited[r][c] = false;
            return;
        }

        // move ahead
        char ch = paths.charAt(step);

        for (int i = 0; i <= 3; i++) {
            if (ch != '?' && dir[i] != ch) continue;

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!isBlocked(nr, nc)) {
                dfs(nr, nc, step + 1);
            }
        }

        visited[r][c] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        paths = br.readLine();

        dfs(0, 0, 0);

        System.out.println(res);
    }
}