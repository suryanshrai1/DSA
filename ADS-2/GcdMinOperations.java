public class GcdMinOperations {

    // Function to find GCD (Greatest Common Divisor)
    public int findGcd(int a, int b) {
        if (b == 0)
            return a;
        return findGcd(b, a % b);
    }

    // Function to compute minimum operations
    public int minOperations(int[] nums) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                cnt++;
        }

        // If there are already some 1's, return (n - count of 1's)
        if (cnt > 0)
            return n - cnt;

        int ans = Integer.MAX_VALUE;

        // Try all subarrays and find one with GCD = 1
        for (int i = 0; i < n - 1; i++) {
            int gcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                gcd = findGcd(gcd, nums[j]);
                if (gcd == 1) {
                    int sublen = j - i + 1;
                    int count = (sublen - 1) + (n - 1);
                    ans = Math.min(ans, count);
                    break; // no need to continue since gcd is already 1
                }
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        GcdMinOperations solution = new GcdMinOperations();

        int[] nums1 = {2, 6, 3, 4};
        int[] nums2 = {2, 4, 6, 8};
        int[] nums3 = {1, 2, 3};

        System.out.println("Minimum operations for [2, 6, 3, 4]: " + solution.minOperations(nums1)); // Expected: 4
        System.out.println("Minimum operations for [2, 4, 6, 8]: " + solution.minOperations(nums2)); // Expected: -1
        System.out.println("Minimum operations for [1, 2, 3]: " + solution.minOperations(nums3));   // Expected: 2
    }
}
