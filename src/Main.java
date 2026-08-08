import java.io.*;
import java.util.*;

public class Main {

    static int[] paths;
    static boolean[] visited = new boolean[81];
    static int res = 0;

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

        // ii) future failure cases
        boolean up = visited[idx - 9];
        boolean down = visited[idx + 9];
        boolean right = visited[idx + 1];
        boolean left = visited[idx - 1];

        // horizontal closure
        if (up
                && down
                && !right
                && !left) {
            return;
        }

        // vertical closure
        if (right
                && left
                && !up
                && !down) {
            return;
        }

        // move ahead
        visited[idx] = true;

        int ch = paths[step];

        if (ch == 0) {
            // up
            if (!visited[idx - 9]) {
                dfs(r - 1, c, step + 1);
            }
        } else if (ch == 1) {
            // Down
            if (!visited[idx + 9]) {
                dfs(r + 1, c, step + 1);
            }
        } else if (ch == 2) {
            // left
            if (!visited[idx - 1]) {
                dfs(r, c - 1, step + 1);
            }
        } else if (ch == 3) {
            // right
            if (!visited[idx + 1]) {
                dfs(r, c + 1, step + 1);
            }
        } else {
            // all
            if (!visited[idx - 9]) {
                dfs(r - 1, c, step + 1);
            }

            if (!visited[idx + 9]) {
                dfs(r + 1, c, step + 1);
            }

            if (!visited[idx - 1]) {
                dfs(r, c - 1, step + 1);
            }

            if (!visited[idx + 1]) {
                dfs(r, c + 1, step + 1);
            }
        }

        visited[idx] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        paths = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case 'U':
                    paths[i] = 0;
                    break;
                case 'D':
                    paths[i] = 1;
                    break;
                case 'L':
                    paths[i] = 2;
                    break;
                case 'R':
                    paths[i] = 3;
                    break;
                default:
                    paths[i] = 4;
                    break;
            }
        }

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