public class ZeroFilledSubarrayCounter {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0L;
        long cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                cnt++;
            else {
                ans += 1L * cnt * (cnt + 1) / 2;
                cnt = 0;
            }
        }
        if (cnt != 0)
            ans += 1L * (cnt * (cnt + 1) / 2);
        return ans;
    }

    public static void main(String[] args) {
        ZeroFilledSubarrayCounter counter = new ZeroFilledSubarrayCounter();
        
        // Sample input
        int[] nums = {1, 0, 0, 2, 0, 0, 0, 3};

        // Calculate result
        long result = counter.zeroFilledSubarray(nums);

        // Output the result
        System.out.println("Number of zero-filled subarrays: " + result);
    }
}
