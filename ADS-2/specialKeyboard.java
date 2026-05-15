import java.util.Arrays;

public class specialKeyboard {
    private int helper(int n, int[] dp) {
        if (n <= 6) {
            return n;
        }
        int ans = 0;
        for (int i = 1; i < n - 3; i++) {
            if (dp[n] != -1) {
                return dp[n];
            }
            int curr = helper(i, dp) * (n - i - 1);
            ans = Math.max(curr, ans);
        }
        dp[n] = ans;
        return dp[n];
    }

    public int optimalKeys(int n) {
        // code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
}
