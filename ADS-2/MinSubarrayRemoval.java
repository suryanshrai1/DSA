import java.util.*;

public class MinSubarrayRemoval {

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum = (sum + num) % p;
        }

        int target = sum % p;
        if (target == 0) return 0;

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int res = n;
        int curr = 0;

        for (int j = 0; j < n; j++) {
            curr = (curr + nums[j]) % p;

            int rem = (curr - target + p) % p;
            if (mp.containsKey(rem)) {
                res = Math.min(res, j - mp.get(rem));
            }

            mp.put(curr, j);
        }
        return res == n ? -1 : res;
    }

    public static void main(String[] args) {
        MinSubarrayRemoval solver = new MinSubarrayRemoval();
        
        // Example test
        int[] nums = {3, 1, 4, 2};
        int p = 6;

        int result = solver.minSubarray(nums, p);
        System.out.println("Minimum subarray length to remove = " + result);
    }
}
