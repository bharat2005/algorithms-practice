import java.io.*;

public class Main {

    static String paths;
    static boolean[][] visited;
    static int res = 0;

    static char[] dir = {'U', 'D', 'L', 'R'};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(int r, int c, int step) {

        // base cases
        // reached desired end
        if (r == 6 && c == 0 && step == 48) {
            res++;
            return;
        }

        // reached at wrong end
        if (step == 48) return;

        // pruning cases

        // i) reaching too early
        if (r == 6 && c == 0) return;

        // ii) future failer cases

        // horizontal closure
        if (visited[r - 1][c]
                && visited[r + 1][c]
                && !visited[r][c - 1]
                && !visited[r][c + 1]) {
            return;
        }

        // vertical closure
        if (visited[r][c - 1]
                && visited[r][c + 1]
                && !visited[r + 1][c]
                && !visited[r - 1][c]) {
            return;
        }

        // move ahead
        visited[r][c] = true;
        char ch = paths.charAt(step);

        for (int i = 0; i <= 3; i++) {
            if (ch != '?' && dir[i] != ch) continue;

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!visited[nr][nc]) {
                dfs(nr, nc, step + 1);
            }
        }

        visited[r][c] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        paths = br.readLine();

        visited = new boolean[9][9];

        // add padding
        for (int i = 0; i < 8; i++) {
            visited[0][i] = true;
            visited[8][i] = true;
            visited[i][0] = true;
            visited[i][8] = true;
        }

        dfs(1, 1, 0);

        System.out.println(res);
    }
}