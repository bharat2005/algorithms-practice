import java.io.*;
import java.util.*;

public class Main {

    static String paths;
    static boolean[][] visited = new boolean[7][7];
    static int res = 0;

    static HashMap<Character, int[]> map = new HashMap<>();

    static {
        map.put('U', new int[]{-1, 0});
        map.put('D', new int[]{1, 0});
        map.put('L', new int[]{0, -1});
        map.put('R', new int[]{0, 1});
    }

    static boolean isBlocked(int row, int column) {
        // out of bound
        if (row < 0 || row > 6 || column < 0 || column > 6) return true;

        // already visited
        if (visited[row][column]) return true;

        // else
        return false;
    }

    static void dfs(int r, int c, int step) {

        // base case
        if (r == 6 && c == 0 && step == 48) {
            res++;
            return;
        }

        // pruning cases (2)

        // i) ending in wrong cell
        if (step == 48) return;

        // ii) future failer cases

        // horizontal closure
        if (isBlocked(r - 1, c)
                && isBlocked(r + 1, c)
                && !isBlocked(r, c - 1)
                && !isBlocked(r, c + 1))
            return;

        // vertical closure
        if (isBlocked(r, c - 1)
                && isBlocked(r, c + 1)
                && !isBlocked(r + 1, c)
                && !isBlocked(r - 1, c))
            return;

        // move ahead
        visited[r][c] = true;

        char ch = paths.charAt(step);

        if (ch == '?') {
            // move all possible dir
            for (char i : new char[]{'U', 'D', 'L', 'R'}) {
                int nr = r + map.get(i)[0];
                int nc = c + map.get(i)[1];

                if (!isBlocked(nr, nc)) {
                    dfs(nr, nc, step + 1);
                }
            }
        } else {
            // move to path dir
            int nr = r + map.get(ch)[0];
            int nc = c + map.get(ch)[1];

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