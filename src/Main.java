import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {
            long k = Long.parseLong(br.readLine());

            long count = 9L;
            long digits = 1L;

            while (k > count * digits) {
                k -= count * digits;
                count *= 10;
                digits++;
            }

            long number = (count / 9) + (k - 1) / digits;
            int digitIndex = (int) ((k - 1) % digits);

            System.out.println(Long.toString(number).charAt(digitIndex));
        }
    }
}