import java.util.*;

public class SubsetSumCounter {

    public static int countSubset(int[] arr, int k) {
        // If all elements are negative and k > 0, no subset is possible
        boolean allNegative = true;
        for (int x : arr) {
            if (x >= 0) {
                allNegative = false;
                break;
            }
        }
        if (allNegative && k > 0) {
            return 0;
        }

        int n = arr.length;
        int[][] dp = new int[n + 1][k + 1];

        // Base case: one subset (empty set) gives sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (arr[i - 1] >= 0 && arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j]
                             + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        // Example test case
        int[] arr = { -5, -3, -2 };
        int k = 4;

        int result = countSubset(arr, k);
        System.out.println(result); // Expected output: 0
    }
}
