public class TrionicSubarrayMaxSum {

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;
        long ans = Long.MIN_VALUE;

        while (i < n) {
            int l = i;
            i++;

            // strictly increasing
            while (i < n && nums[i - 1] < nums[i]) {
                i++;
            }
            if (i == l + 1) {
                continue;
            }

            int p = i - 1;
            long s = nums[p - 1] + nums[p];

            // strictly decreasing
            while (i < n && nums[i - 1] > nums[i]) {
                s += nums[i];
                i++;
            }
            if (i == p + 1 || i == n || nums[i - 1] == nums[i]) {
                continue;
            }

            int q = i - 1;
            s += nums[i];
            i++;

            // second increasing (right side)
            long mx = 0, t = 0;
            while (i < n && nums[i - 1] < nums[i]) {
                t += nums[i];
                i++;
                mx = Math.max(mx, t);
            }
            s += mx;

            // first increasing (left side)
            mx = 0;
            t = 0;
            for (int j = p - 2; j >= l; j--) {
                t += nums[j];
                mx = Math.max(mx, t);
            }
            s += mx;

            ans = Math.max(ans, s);
            i = q;
        }

        return ans;
    }

    public static void main(String[] args) {
        TrionicSubarrayMaxSum solver = new TrionicSubarrayMaxSum();

        int[] nums = {1, 3, 5, 4, 2, 6, 8};
        long result = solver.maxSumTrionic(nums);

        System.out.println("Maximum trionic subarray sum: " + result);
    }
}
