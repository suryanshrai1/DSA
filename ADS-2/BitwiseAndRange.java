import java.util.*;

public class BitwiseAndRange {

    // Function to compute AND of all numbers in the range [L, R]
    public static int andInRange(int L, int R) {
        int shift = 0;

        // Find the common prefix
        while (L < R) {
            L >>= 1;
            R >>= 1;
            shift++;
        }

        // Restore the shifted bits
        return L << shift;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter L: ");
        int L = sc.nextInt();

        System.out.print("Enter R: ");
        int R = sc.nextInt();

        int result = andInRange(L, R);
        System.out.println("Bitwise AND from " + L + " to " + R + " = " + result);

        sc.close();
    }
}
