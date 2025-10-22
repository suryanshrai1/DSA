import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class MaxFrequencyFinder {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums); // o(nlogn)

        HashMap<Integer, Integer> freq = new HashMap<>(); // o(n)
        TreeSet<Integer> nodes = new TreeSet<>(); // o(3*n)

        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
            nodes.add(num - k);
            nodes.add(num);
            nodes.add(num + k);
        }

        int ans = 0;
        // o(3 * n * log(n))
        for (int node : nodes) {
            int l = leftBound(nums, node - k);
            int r = rightBound(nums, node + k);
            int currAns = Math.min(numOperations + freq.getOrDefault(node, 0), r - l + 1);
            ans = Math.max(ans, currAns);
        }

        return ans;
    }

    private int leftBound(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int rightBound(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > value) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MaxFrequencyFinder finder = new MaxFrequencyFinder();

        int[] nums = {1, 2, 3, 4, 5};  // Example input
        int k = 2;  // Example k value
        int numOperations = 2;  // Example number of operations

        int result = finder.maxFrequency(nums, k, numOperations);
        System.out.println("Maximum Frequency: " + result);
    }
}
