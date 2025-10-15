import java.util.List;
import java.util.ArrayList;

public class MaxIncreasingSubarrays {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0, prev = 0, count = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) count++;
            else {
                prev = count;
                count = 1;
            }
            ans = Math.max(ans, Math.max(count / 2, Math.min(prev, count)));
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxIncreasingSubarrays solution = new MaxIncreasingSubarrays();
        
        // Example input list
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        
        int result = solution.maxIncreasingSubarrays(nums);
        System.out.println("Max increasing subarrays result: " + result);
    }
}
