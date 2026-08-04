import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {
            long k = Long.parseLong(br.readLine());

            long count = 9L;
            long digits = 1L;

            while (k > count * digits) {
                count *= 10;
                digits++;
            }

            long num = count / 9 - 1 + k / digits;

            char idxDig;
            if (k % digits == 0L) {
                String s = Long.toString(num);
                idxDig = s.charAt(s.length() - 1);
            } else {
                String s = Long.toString(num + 1);
                idxDig = s.charAt((int) (k % digits));
            }

            System.out.println(idxDig);
        }
    }
}