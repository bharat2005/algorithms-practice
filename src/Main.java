import java.io.*;

public class Main {

    static String paths;
    static boolean[] visited;
    static int res;

    static char[] dir = {'U', 'D', 'L', 'R'};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(int r, int c, int step) {
        int idx = r * 9 + c;

        // base cases
        // reached desired end
        if (idx == 72 && step == 48) {
            res++;
            return;
        }

        // reached at wrong end
        if (step == 48) return;





        // pruning cases
        // i) reaching too early
        if (idx == 72) return;

        // ii) future failer cases

        // horizontal closure
        if (visited[idx - 9]
                && visited[idx + 9]
                && !visited[idx - 1]
                && !visited[idx + 1]) {
            return;
        }

        // vertical closure
        if (visited[idx - 1]
                && visited[idx + 1]
                && !visited[idx + 9]
                && !visited[idx - 9]) {
            return;
        }





        // move ahead
        visited[idx] = true;

        char ch = paths.charAt(step);

        for (int i = 0; i <= 3; i++) {
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

        visited = new boolean[81];

        // add padding
        for (int i = 0; i < 8; i++) {
            visited[i] = true;
            visited[72 + i] = true;
            visited[9 * i] = true;
            visited[9 * i + 8] = true;
        }

        res = 0;

        dfs(1, 1, 0);

        System.out.println(res);
    }
}