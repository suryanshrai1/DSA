import java.util.*;

public class SumOfSubarrayMinimums {

    public static int sumSubMins(int[] arr) {
        int n = arr.length;
        long mod = 1000000007;
        long result = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Calculate left boundaries
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate right boundaries
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate sum of subarray minimums
        for (int i = 0; i < n; i++) {
            long count = (long) (i - left[i]) * (right[i] - i);
            long contribution = (count * arr[i]) % mod;
            result = (result + contribution) % mod;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int result = sumSubMins(arr);
        System.out.println("Sum of Subarray Minimums: " + result);
    }
}