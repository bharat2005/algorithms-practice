import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] arr;
    static int n;
    static boolean[] column;
    static boolean[] dig1;
    static boolean[] dig2;
    static int ans = 0;

    static void dfs(int rowIndex) {
        // Base case
        if (rowIndex == n) {
            ans++;
            return;
        }

        // Recursive part
        for (int i = 0; i < n; i++) {

            // conditions --> row + column + dig1 + dig2 + extra condition
            boolean isExtraRestricted = arr[rowIndex][i] == '*';
            boolean isColumnRestricted = column[i];
            boolean isDig1Restricted = dig1[rowIndex + i];
            boolean isDig2Restricted = dig2[rowIndex - i + 7];

            if (isColumnRestricted || isDig1Restricted || isDig2Restricted || isExtraRestricted) {
                continue;
            }

            // mark restricted
            column[i] = true;
            dig1[rowIndex + i] = true;
            dig2[rowIndex - i + 7] = true;

            dfs(rowIndex + 1);

            // unmark
            column[i] = false;
            dig1[rowIndex + i] = false;
            dig2[rowIndex - i + 7] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[8][];
        for (int i = 0; i < 8; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        n = arr.length;
        column = new boolean[n];
        dig1 = new boolean[n * 2 - 1];
        dig2 = new boolean[n * 2 - 1];

        dfs(0);

        System.out.print(ans);
    }
}