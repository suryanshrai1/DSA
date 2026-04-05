public class targetSum {
    public int totalWays(int[] arr, int target) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum < target || (sum + target) % 2 != 0 || target < -sum) {
            return 0;
        }

        int subSetSum = (sum + target) / 2;
        int[] dp = new int[subSetSum + 1];
        dp[0] = 1;

        for (int num : arr) {
            for (int j = subSetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[subSetSum];
    }
}