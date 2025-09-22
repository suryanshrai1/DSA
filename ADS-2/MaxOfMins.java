import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaxOfMins {

    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;

        // Step 1: Find Previous Smaller Element (PSE) indices
        int[] left = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Reuse stack to find Next Smaller Element (NSE) indices
        stack.clear();

        // Step 1 (cont.): Find Next Smaller Element (NSE) indices
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Step 2 & 3: For each element, find its window length and update the potential answer
        int[] maxForLen = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            maxForLen[len] = Math.max(maxForLen[len], arr[i]);
        }

        // Step 4: Fill missing answers by ensuring the result is non-increasing
        for (int i = n - 1; i >= 1; i--) {
            maxForLen[i] = Math.max(maxForLen[i], maxForLen[i + 1]);
        }

        // Format the final result into an ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(maxForLen[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxOfMins solution = new MaxOfMins();
        int[] arr = {1, 3, 2, 4, 5};
        ArrayList<Integer> result = solution.maxOfMins(arr);
        
        System.out.println("Result: " + result);
    }
}
