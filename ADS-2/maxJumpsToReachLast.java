public class maxJumpsToReachLast {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);
        ans[0] = 0;

        for (int i = 1; i < n; i++) {
            int start = 0;

            while (start < i) {
                if (ans[start] != -1 &&
                        Math.abs(nums[i] - nums[start]) <= target) {

                    ans[i] = Math.max(ans[i], ans[start] + 1);
                }
                start++;
            }
        }
        return ans[n - 1];
    }
}