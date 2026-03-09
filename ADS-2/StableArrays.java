import java.util.Arrays;
import java.util.Scanner;

public class StableArrays {
    private static final int MOD = 1000000007;

    private int solve(int zero, int one, int limit, int lastSeen, int consCount, int[][][][] dp) {

        if (consCount > limit)
            return 0;

        if (zero == 0 && one == 0)
            return 1;

        if (lastSeen != -1 && dp[zero][one][lastSeen][consCount] != -1) {
            return dp[zero][one][lastSeen][consCount];
        }

        int ans = 0;

        if (zero > 0) {
            int newLast = 0;
            int newCount = (lastSeen == 0) ? consCount + 1 : 1;
            ans = (ans + solve(zero - 1, one, limit, newLast, newCount, dp)) % MOD;
        }

        if (one > 0) {
            int newLast = 1;
            int newCount = (lastSeen == 1) ? consCount + 1 : 1;
            ans = (ans + solve(zero, one - 1, limit, newLast, newCount, dp)) % MOD;
        }

        if (lastSeen != -1) {
            dp[zero][one][lastSeen][consCount] = ans;
        }

        return ans;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][][][] dp = new int[zero + 1][one + 1][2][limit + 1];

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int k = 0; k < 2; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        return solve(zero, one, limit, -1, 0, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int zero = sc.nextInt();
        int one = sc.nextInt();
        int limit = sc.nextInt();

        StableArrays obj = new StableArrays();
        int result = obj.numberOfStableArrays(zero, one, limit);

        System.out.println(result);

        sc.close();
    }
}