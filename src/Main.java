import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        final int MOD = 1_000_000_000 + 7;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long ans = 1L;
        for (int i = 0; i < n; i++) {
            ans *= 2 % MOD;
        }

        System.out.println(ans % MOD);
    }
}