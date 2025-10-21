class MaxFrequencySolution {
    public int maxFrequency(int[] nums, int k, int ops) {
        int highVal = 0, lowVal = Integer.MAX_VALUE;

        // Find min and max in nums
        for (int val : nums) {
            highVal = Math.max(highVal, val);
            lowVal = Math.min(lowVal, val);
        }

        int[] count = new int[highVal + 1];
        int[] preSum = new int[highVal + 1];

        // Frequency count
        for (int val : nums) {
            count[val]++;
        }

        // Prefix sum of frequencies
        for (int i = lowVal; i <= highVal; i++) {
            preSum[i] = preSum[i - 1] + count[i];
        }

        int best = 0;

        // Try making each number the target value
        for (int t = lowVal; t <= highVal; t++) {
            int leftSum = 0;
            if (t - k - 1 > 0) leftSum = preSum[t - k - 1];

            int rightSum = (t + k <= highVal) ? preSum[t + k] : preSum[highVal];

            int nearby = rightSum - leftSum - count[t];
            int canMake = count[t] + Math.min(ops, nearby);

            best = Math.max(best, canMake);
        }

        return best;
    }

    public static void main(String[] args) {
        MaxFrequencySolution solution = new MaxFrequencySolution();
        
        // Test example
        int[] nums = {3, 9, 12, 15};
        int k = 2;
        int ops = 4;
        
        int result = solution.maxFrequency(nums, k, ops);
        System.out.println("Maximum frequency: " + result);  // Output the result
    }
}
