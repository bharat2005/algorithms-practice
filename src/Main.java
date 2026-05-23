import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        final int MOD = 1_000_000_000 + 7;
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        long ans = 1L;
        for (int i = 0; i < n; i++) {
            ans = (2 * ans) % MOD;
        }
        System.out.println(ans);
    }
}