import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }

        arr[0][0] = 0;

        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});

        int[] dr = {2, 2, -2, -2, 1, -1, -1, 1};
        int[] dc = {1, -1, -1, 1, 2, 2, -2, -2};

        while (!que.isEmpty()) {
            int[] cur = que.removeFirst();
            int r = cur[0];
            int c = cur[1];

            // explore all directions
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                if (arr[nr][nc] == -1) {
                    arr[nr][nc] = arr[r][c] + 1;
                    que.add(new int[]{nr, nc});
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] row : arr) {
            for (int x : row) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}