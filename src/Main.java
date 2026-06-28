import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static long[] ls;
    static long total;
    static long min = Long.MAX_VALUE;

    static void dfs(int currIdx, long currSum) {
        if (currIdx == n) {
            // update final anser min
            min = Math.min(min, Math.abs(total - currSum - currSum));
            return;
        }

        dfs(currIdx + 1, currSum + ls[currIdx]);
        dfs(currIdx + 1, currSum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] parts = br.readLine().split(" ");
        ls = new long[n];

        for (int i = 0; i < n; i++) {
            ls[i] = Long.parseLong(parts[i]);
            total += ls[i];
        }

        dfs(0, 0);

        System.out.println(min);
    }
}