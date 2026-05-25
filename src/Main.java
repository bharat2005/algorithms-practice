import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // store freq
        int[] arr = new int[26];
        for (char ch : str.toCharArray()) {
            arr[ch - 'A']++;
        }

        // check odd count & mid
        int oddCount = 0;
        Integer middle = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                oddCount++;
                middle = i;
            }
        }

        if (oddCount > 1) {
            System.out.println("NO SOLUTION");
            return;
        }

        // create left part
        StringBuilder left = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                for (int j = 0; j < arr[i] / 2; j++) {
                    left.append((char) ('A' + i));
                }
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        if (middle != null) {
            for (int i = 0; i < arr[middle]; i++) {
                left.append((char) ('A' + middle));
            }
        }

        System.out.println(left.toString() + right);
    }
}