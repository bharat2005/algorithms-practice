import java.io.*;
import java.util.*;

public class Main {

    static String str;
    static StringBuilder sb = new StringBuilder();
    static List<String> res = new ArrayList<>();
    static TreeMap<Character, Integer> map = new TreeMap<>();

    static void rec() {
        if (sb.length() == str.length()) {
            res.add(sb.toString());
            return;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            if (count == 0) continue;

            map.put(ch, count - 1);
            sb.append(ch);

            rec();

            sb.deleteCharAt(sb.length() - 1);
            map.put(ch, count);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        rec();

        System.out.println(res.size());

        for (String s : res) {
            System.out.println(s);
        }
    }
}