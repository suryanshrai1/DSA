import java.util.*;

public class KBitFlipSolver {

    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flipCount = 0;
        int currentFlips = 0;
        int[] isFlipped = new int[n]; // Tracks if a flip started at this index

        for (int i = 0; i < n; i++) {

            if (i >= k) {
                currentFlips ^= isFlipped[i - k];
            }

            // Check effective value after flips
            if ((arr[i] ^ currentFlips) == 0) {

                if (i + k > n) {
                    return -1;
                }

                currentFlips ^= 1;
                isFlipped[i] = 1;
                flipCount++;
            }
        }

        return flipCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements (0 or 1):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter value of k:");
        int k = sc.nextInt();

        KBitFlipSolver obj = new KBitFlipSolver();
        int result = obj.kBitFlips(arr, k);

        System.out.println("Minimum K Bit Flips: " + result);

        sc.close();
    }
}