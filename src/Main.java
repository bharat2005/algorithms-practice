import java.io.IOException;

public class Main {

    static byte[] input;
    static int[] path = new int[48];
    static boolean[] visited = new boolean[81];
    static int res = 0;

    static void dfs(int r, int c, int step) {
        int idx = r * 9 + c;

        // Reached target cell (7, 1) in 1-indexed padded grid
        if (r == 7 && c == 1) {
            if (step == 48) res++;
            return;
        }
        if (step == 48) return;

        // Pruning: Split Path Detection (Dead End)
        // Check surrounding cells directly without bounds checks
        boolean u = visited[idx - 9];
        boolean d = visited[idx + 9];
        boolean l = visited[idx - 1];
        boolean rDir = visited[idx + 1];

        // Horizontal trap or Vertical trap
        if (u && d && !l && !rDir) return;
        if (l && rDir && !u && !d) return;

        visited[idx] = true;

        int dir = path[step];

        // Unrolled directional branching
        if (dir == 0) { // U
            if (!visited[idx - 9]) dfs(r - 1, c, step + 1);
        } else if (dir == 1) { // D
            if (!visited[idx + 9]) dfs(r + 1, c, step + 1);
        } else if (dir == 2) { // L
            if (!visited[idx - 1]) dfs(r, c - 1, step + 1);
        } else if (dir == 3) { // R
            if (!visited[idx + 1]) dfs(r, c + 1, step + 1);
        } else { // '?'
            if (!visited[idx - 9]) dfs(r - 1, c, step + 1);
            if (!visited[idx + 9]) dfs(r + 1, c, step + 1);
            if (!visited[idx - 1]) dfs(r, c - 1, step + 1);
            if (!visited[idx + 1]) dfs(r, c + 1, step + 1);
        }

        visited[idx] = false;
    }

    public static void main(String[] args) throws Exception {
        input = System.in.readAllBytes();

        int pos = 0;
        while (pos < input.length && input[pos] <= 32) pos++;
        if (pos >= input.length) return;

        // Pre-parse directions to integer IDs: U=0, D=1, L=2, R=3, ?=4
        for (int i = 0; i <= 47; i++) {
            switch ((char) input[pos + i]) {
                case 'U':
                    path[i] = 0;
                    break;
                case 'D':
                    path[i] = 1;
                    break;
                case 'L':
                    path[i] = 2;
                    break;
                case 'R':
                    path[i] = 3;
                    break;
                default:
                    path[i] = 4;
                    break;
            }
        }

        // 9x9 Grid flattened to 1D array of size 81
        // Cells (1..7, 1..7) represent the valid 7x7 grid.

        // Pre-mark boundaries as visited (rows 0, 8 and cols 0, 8)
        for (int i = 0; i <= 8; i++) {
            visited[i] = true;          // Top border (row 0)
            visited[72 + i] = true;     // Bottom border (row 8)
            visited[i * 9] = true;      // Left border (col 0)
            visited[i * 9 + 8] = true;  // Right border (col 8)
        }

        // Start DFS at (1, 1) in padded grid
        dfs(1, 1, 0);

        System.out.println(res);
    }
}