import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int fac = Integer.parseInt(br.readLine());
        int fives = 0;
        int twos = 0;

        while (fac != 0) {

            int num = fac;
            while (num % 5 == 0 && num != 0) {
                fives++;
                num /= 5;
            }

            int num2 = fac;
            while (num2 % 2 == 0 && num2 != 0) {
                twos++;
                num2 /= 2;
            }

            fac--;
        }

        System.out.println(Math.min(twos, fives));
    }
}