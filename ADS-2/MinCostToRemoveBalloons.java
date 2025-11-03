public class MinCostToRemoveBalloons {

    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        if (n == 1) return 0;
        int pre = 0, cur = 1;
        int res = 0;

        while (cur < n) {
            if (colors.charAt(pre) == colors.charAt(cur)) {
                res += Math.min(neededTime[pre], neededTime[cur]);
                if (neededTime[pre] > neededTime[cur]) {
                    cur++;
                    continue;
                }
            }
            pre = cur;
            cur++;
        }
        return res;
    }

    public static void main(String[] args) {
        MinCostToRemoveBalloons solution = new MinCostToRemoveBalloons();

        // Example test case
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};

        int result = solution.minCost(colors, neededTime);
        System.out.println("Minimum total time to remove balloons: " + result);
    }
}
