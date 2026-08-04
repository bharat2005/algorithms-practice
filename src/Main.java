import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fs = new FastReader();
        StringBuilder out = new StringBuilder();

        int q = fs.nextInt();

        while (q-- > 0) {
            long k = fs.nextLong();
            long count = 9L;
            long digits = 1L;

            while (k > count * digits) {
                k -= count * digits;
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
                idxDig = s.charAt((int) (k % digits) - 1);
            }

            out.append(idxDig).append('\n');
        }

        System.out.print(out);
    }
}