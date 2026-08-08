import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String paths;

    static boolean[] visited = new boolean[81];

    static int res = 0;

    static char[] dir = {'U', 'D', 'L', 'R'};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(int r, int c, int step) {
        int idx = r * 9 + c;

        // base cases
        // reached desired end
        if (idx == 64 && step == 48) {
            res++;
            return;
        }

        // reached at wrong end
        if (step == 48) return;

        // pruning cases

        // i) reaching too early
        if (idx == 64) return;

        // ii) future failer cases
        boolean up = visited[idx - 9];
        boolean down = visited[idx + 9];
        boolean right = visited[idx + 1];
        boolean left = visited[idx - 1];

        // horizontal closure
        if (up && down && !right && !left) return;

        // vertical closure
        if (right && left && !up && !down) return;

        // move ahead
        visited[idx] = true;

        char ch = paths.charAt(step);

        for (int i = 0; i < 4; i++) {
            if (ch != '?' && dir[i] != ch) continue;

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!visited[nr * 9 + nc]) {
                dfs(nr, nc, step + 1);
            }
        }

        visited[idx] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        paths = br.readLine();

        // add padding
        for (int i = 0; i <= 8; i++) {
            visited[i] = true;
            visited[72 + i] = true;
            visited[9 * i] = true;
            visited[9 * i + 8] = true;
        }

        dfs(1, 1, 0);

        System.out.println(res);
    }
}