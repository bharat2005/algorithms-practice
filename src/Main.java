import java.io.*;
import java.util.*;

public class Main {

    static String str;
    static StringBuilder sb = new StringBuilder();
    static char[] chars;
    static boolean[] bools;
    static List<String> res = new ArrayList<>();

    static void rec() {
        if (sb.length() == str.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (bools[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !bools[i - 1]) continue;

            bools[i] = true;
            sb.append(chars[i]);
            rec();
            sb.deleteCharAt(sb.length() - 1);
            bools[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        // String str = "aabac";

        chars = str.toCharArray();
        Arrays.sort(chars);

        bools = new boolean[chars.length];

        rec();

        System.out.println(res.size());
        for (String s : res) {
            System.out.println(s);
        }
    }
}