import java.util.HashMap;
import java.util.Map;

public class LongestBalancedSubarray {

    public int longestBalanced(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> even = new HashMap<>();
            Map<Integer, Integer> odd = new HashMap<>();

            for (int j = i; j < n; j++) {
                Map<Integer, Integer> map = (nums[j] & 1) == 1 ? odd : even;
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                if (odd.size() == even.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestBalancedSubarray solution = new LongestBalancedSubarray();

        int[] nums = {1, 2, 3, 4, 5, 6};
        int result = solution.longestBalanced(nums);

        System.out.println("Length of longest balanced subarray: " + result);
    }
}
