import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {

    static int n;
    static int[] ls;
    static int total;
    static int min = Integer.MAX_VALUE;

    static void dfs(int currIdx, int currSum) {
        if (currIdx == n) {
            // update final anser min
            min = abs(total - currSum - currSum);
            return;
        }

        dfs(currIdx + 1, currSum + ls[currIdx]);
        dfs(currIdx + 1, currSum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        ls = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        total = 0;
        for (int i = 0; i < n; i++) {
            ls[i] = Integer.parseInt(st.nextToken());
            total += ls[i];
        }

        dfs(0, 0);
    }
}