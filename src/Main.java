import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int fac = 5;
        int ans = 0;

        while (fac <= n) {
            ans += n / fac;
            fac *= 5;
        }

        System.out.println(ans);
    }
}