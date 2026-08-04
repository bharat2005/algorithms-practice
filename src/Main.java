import java.io.*;
import java.util.*;

public class Main {

    static boolean fesCheck(Map<Character, Integer> freq) {
        return fesCheck(freq, '0');
    }

    static boolean fesCheck(Map<Character, Integer> freq, char prev) {
        int maxFreq = Integer.MIN_VALUE;
        char letter = '0';
        int sum = 0;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            sum += value;
            if (maxFreq > value) {
                maxFreq = maxFreq;
            } else {
                letter = key;
                maxFreq = value;
            }
        }

        return maxFreq <= (sum + 1) / 2 && prev != letter;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char prev = '0';
        StringBuilder sb = new StringBuilder();

        // build freq
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // initial check for whole feasibility
        if (!fesCheck(freq)) {
            System.out.println(-1);
            return;
        }

        // try building res from ascending A-Z for lex min
        for (int i = 0; i < str.length(); i++) {
            boolean flag = false;

            for (char letter = 'A'; letter <= 'Z'; letter++) {
                // default conditions
                if (freq.getOrDefault(letter, 0) == 0) continue;
                if (prev == letter) continue;

                // try with curr letter
                freq.put(letter, freq.get(letter) - 1);

                if (fesCheck(freq)) {
                    sb.append(letter);
                    prev = letter;
                    flag = true;
                    break;
                }

                // if not possible, undo try
                freq.put(letter, freq.get(letter) + 1);
            }

            if (!flag) {
                return;
            }
        }

        System.out.println(sb.toString());
    }
}