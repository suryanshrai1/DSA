import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSubarraySumInRange {
    /**
     * Finds the maximum subarray sum with length in the range [a, b].
     *
     * @param arr The input array of integers.
     * @param a   The minimum length of the subarray.
     * @param b   The maximum length of the subarray.
     * @return The maximum possible sum.
     */
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;

        // Step 1: Create a prefix sum array.
        // We use 'long' to prevent potential integer overflow during sum calculation.
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        long maxSum = Long.MIN_VALUE;

        // This deque stores indices 'j' from the prefix sum array, corresponding to
        // potential start points of subarrays. It finds the minimum prefix sum in a 
        // sliding window efficiently.
        Deque<Integer> dq = new ArrayDeque<>();

        // Step 2: Iterate through all possible ending indices 'k' of a subarray arr[j...k].
        for (int k = 0; k < n; k++) {

            // For a fixed ending point 'k', we want to maximize prefix[k+1] - prefix[j]
            // by minimizing prefix[j] over the valid range for 'j': [k-b+1, k-a+1].

            // Add the rightmost index of the new window, j = k-a+1, to the deque.
            // This is only possible if k >= a-1, ensuring the subarray has at least length 'a'.
            if (k >= a - 1) {
                int newIndexJ = k - a + 1;
                // Maintain the monotonic property: remove indices from the back whose
                // prefix sums are greater than or equal to the new one.
                while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[newIndexJ]) {
                    dq.pollLast();
                }
                dq.offerLast(newIndexJ);
            }

            // Remove indices from the front of the deque that are now outside the window's
            // left boundary, which is k-b+1.
            if (!dq.isEmpty() && dq.peekFirst() < k - b + 1) {
                dq.pollFirst();
            }

            // If the deque is not empty, a valid subarray can be formed.
            // The index at the front gives the minimum prefix sum in the current window.
            if (!dq.isEmpty()) {
                long currentSum = prefix[k + 1] - prefix[dq.peekFirst()];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        // The problem signature requires an int return type. We cast the final result,
        // which might be an issue if the sum exceeds Integer.MAX_VALUE.
        return (int) maxSum;
    }

    public static void main(String[] args) {
        MaxSubarraySumInRange solver = new MaxSubarraySumInRange();

        int[] arr = {1, -2, 3, 4, -1, 2, 1, -5, 4};
        int a = 2;
        int b = 4;

        int maxSum = solver.maxSubarrSum(arr, a, b);
        System.out.println("Maximum subarray sum with length between " + a + " and " + b + " is: " + maxSum);
    }
}
