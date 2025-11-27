import java.util.HashMap;

public class MaxSubarrayModuloK {

    public long maxSubarraySum(int[] nums, int k) {
        HashMap<Integer, Long> mp = new HashMap<>();
        mp.put(0, 0L);
        
        long sum = 0;
        long ans = Long.MIN_VALUE;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            int rem = (j + 1) % k;

            if (mp.containsKey(rem)) {
                ans = Math.max(ans, sum - mp.get(rem));
                mp.put(rem, Math.min(sum, mp.get(rem)));
            } else {
                mp.put(rem, sum);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxSubarrayModuloK solver = new MaxSubarrayModuloK();

        int[] nums = {3, -2, 5, -1, 6};
        int k = 3;

        long result = solver.maxSubarraySum(nums, k);
        System.out.println("Maximum subarray sum with modulo pattern: " + result);
    }
}
