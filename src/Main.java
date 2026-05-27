import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] parts = br.readLine().split(" ");

        List<Integer> arr = new ArrayList<>();
        for (String s : parts) {
            arr.add(Integer.parseInt(s));
        }

        Collections.sort(arr);

        // int n = 5;
        // List<Integer> arr = Arrays.asList(3, 2, 7, 4, 1);
        // arr.sort(Collections.reverseOrder());

        int g1 = arr.get(0);
        int g2 = arr.get(1);

        for (int i = 2; i < n; i++) {
            int num = arr.get(i);

            if (Math.abs(g1 + num - g2) < Math.abs(g2 + num - g1)) {
                // System.out.println(Math.abs(g1 + num - g2) + " < " + Math.abs(g2 + num - g1));
                g1 += num;
            } else {
                // System.out.println(Math.abs(g1 + num - g2) + " > " + Math.abs(g2 + num - g1));
                g2 += num;
            }
        }

        System.out.println(Math.abs(g1 - g2));
    }
}