import java.util.*;

public class ConcatenatedBinaryCalculator {

    public static int concatenatedBinary(int n) {
        List<Integer> bits = new ArrayList<>();

        // Concatenate binary representations from 1 to n
        for (int i = 1; i <= n; i++) {
            int x = i;
            List<Integer> temp = new ArrayList<>();

            while (x > 0) {
                temp.add(x % 2);
                x /= 2;
            }

            // Store bits in correct order
            for (int j = temp.size() - 1; j >= 0; j--) {
                bits.add(temp.get(j));
            }
        }

        int mod = 1_000_000_007;
        long pow2 = 1;
        long ans = 0;

        // Convert concatenated binary to decimal
        for (int i = bits.size() - 1; i >= 0; i--) {
            ans = (ans + pow2 * bits.get(i)) % mod;
            pow2 = (pow2 * 2) % mod;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = scanner.nextInt();

        int result = concatenatedBinary(n);
        System.out.println("Concatenated Binary Result: " + result);

        scanner.close();
    }
}