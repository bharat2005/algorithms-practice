import java.io.*;
import java.util.*;

public class Main {

    static List<String> res = new ArrayList<>();

    static void rec(String string, List<Character> avail) {
        if (avail.size() == 0) {
            res.add(string);
            return;
        }

        List<Character> nAvail = new ArrayList<>(avail);

        for (char ch : avail) {
            nAvail.remove(Character.valueOf(ch));
            rec(string + ch, nAvail);
            nAvail.add(ch);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        List<Character> avail = new ArrayList<>();
        for (char c : str.toCharArray()) {
            avail.add(c);
        }

        rec("", avail);

        List<String> distinct = new ArrayList<>(new LinkedHashSet<>(res));

        System.out.println(distinct.size());

        Collections.sort(distinct);

        for (String s : distinct) {
            System.out.println(s);
        }
    }
}