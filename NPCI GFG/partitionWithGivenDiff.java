public class partitionWithGivenDiff {
    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // If totalSum + diff is odd or negative, a valid S1 is not possible
        if ((totalSum + diff) % 2 != 0 || (totalSum + diff) < 0) {
            return 0;
        }

        int targetSum = (totalSum + diff) / 2;

        // DP array to store the number of ways to achieve each sum
        int[] dp = new int[targetSum + 1];
        dp[0] = 1; // One way to get a sum of 0 (empty subset)

        for (int num : arr) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[targetSum];
    }
}