import java.util.Arrays;

public class cntSortedDigGrp {
    int[][] memo;

    public int validGroups(String s) {
        int n = s.length();

        memo = new int[n + 1][9 * n + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, s);
    }

    private int solve(int index, int prevSum, String s) {
        if (index == s.length()) {
            return 1;
        }

        if (memo[index][prevSum] != -1) {
            return memo[index][prevSum];
        }

        int currentSum = 0;
        int count = 0;

        for (int i = index; i < s.length(); i++) {
            currentSum += s.charAt(i) - '0';

            if (currentSum >= prevSum) {
                count += solve(i + 1, currentSum, s);
            }
        }

        return memo[index][prevSum] = count;
    }
}