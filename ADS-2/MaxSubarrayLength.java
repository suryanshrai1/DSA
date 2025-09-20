import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class MaxSubarrayLength {
    public static int longestSubarray(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        // Step 1: Find the next greater element for each element
        int[] next_greater = new int[n];
        Arrays.fill(next_greater, n); // Default to n if no greater element exists
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                next_greater[stack.pop()] = i;
            }
            stack.push(i);
        }

        // Step 2: Find the previous greater element for each element
        int[] prev_greater = new int[n];
        Arrays.fill(prev_greater, -1); // Default to -1 if no greater element exists
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                prev_greater[stack.pop()] = i;
            }
            stack.push(i);
        }

        int maxLength = 0;

        // Step 3: Iterate through each element as a potential maximum
        for (int i = 0; i < n; i++) {
            // The range where arr[i] is the maximum element
            int left_boundary = prev_greater[i];
            int right_boundary = next_greater[i];
            
            // The length of the subarray where arr[i] is the maximum
            int len = right_boundary - left_boundary - 1;
            
            // The value of the maximum element in this subarray
            int max_val = arr[i];

            // Check if the condition holds: max_val <= length
            if (max_val <= len) {
                maxLength = Math.max(maxLength, len);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test the method with an example array
        int[] arr = {1, 3, 2, 1, 4, 5, 2};
        int result = longestSubarray(arr);
        System.out.println("The longest subarray length is: " + result);
    }
}
