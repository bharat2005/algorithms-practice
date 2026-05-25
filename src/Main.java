import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            String[] parts = br.readLine().split(" ");

            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            if (((x + y) % 3 == 0) &&
                    ((x % 3 == 0 && y % 3 == 0) ||
                            (x % 3 != 0 && y % 3 != 0))) {

                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}