import java.util.*;

public class MinFlipsBinaryString {

    public static int minFlips(String s) {

        int n = s.length();
        s = s + s;

        int count = 0;

        for (int i = 0; i < n; i++) {
            count += (s.charAt(i) ^ i) & 1;
        }

        int ans = Math.min(count, n - count);

        for (int j = n; j < 2 * n; j++) {

            count += (s.charAt(j) ^ j) & 1;
            count -= (s.charAt(j - n) ^ (j - n)) & 1;

            ans = Math.min(ans, Math.min(count, n - count));
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String s = sc.next();

        int result = minFlips(s);

        System.out.println("Minimum flips needed: " + result);

        sc.close();
    }
}