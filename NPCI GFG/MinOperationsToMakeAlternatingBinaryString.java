import java.util.Scanner;

public class MinOperationsToMakeAlternatingBinaryString {

    static int helper(String s, int prev) {
        int n = s.length();
        int curr;
        int res = 0;

        if ((s.charAt(0) - '0') != prev) res++;

        for (int i = 1; i < n; i++) {
            curr = s.charAt(i) - '0';

            if (curr != (1 ^ prev)) {
                res++;
                curr = 1 ^ prev;
            }

            prev = curr;
        }

        return res;
    }

    public static int minOperations(String s) {
        return Math.min(helper(s, 0), helper(s, 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String s = sc.next();

        int result = minOperations(s);

        System.out.println("Minimum operations needed: " + result);

        sc.close();
    }
}