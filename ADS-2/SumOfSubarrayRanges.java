import java.util.*;

public class SumOfSubarrayRanges {

    public static int subarrayRanges(int[] arr) {
        int n = arr.length;
        long sumMax = sumSubarrayMax(arr, n);
        long sumMin = sumSubarrayMin(arr, n);
        return (int) (sumMax - sumMin);
    }

    private static long sumSubarrayMin(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] > arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? mid + 1 : mid - stack.peek();
                int right = i - mid;
                sum += (long) arr[mid] * left * right;
            }
            stack.push(i);
        }
        return sum;
    }

    private static long sumSubarrayMax(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] < arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? mid + 1 : mid - stack.peek();
                int right = i - mid;
                sum += (long) arr[mid] * left * right;
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        System.out.println("Output: " + subarrayRanges(arr1)); // 4

        int[] arr2 = {-32, 0, -2, 72};
        System.out.println("Output: " + subarrayRanges(arr2)); // 318
    }
}
