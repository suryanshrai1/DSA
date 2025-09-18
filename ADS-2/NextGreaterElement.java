import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ans.add(-1); // Initialize with -1
        }

        Stack<Integer> st = new Stack<>(); // Stores indices

        // Iterate twice to handle circularity
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currentElementIndex = i % n;

            // Pop elements from stack that are less than or equal to current element
            while (!st.isEmpty() && arr[st.peek()] <= arr[currentElementIndex]) {
                st.pop();
            }

            // If stack is not empty and we are processing original array elements
            if (i < n && !st.isEmpty()) {
                ans.set(currentElementIndex, arr[st.peek()]);
            }

            // Push current element's index onto the stack
            st.push(currentElementIndex);
        }
        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();

        // Test with an example array
        int[] arr = {5, 3, 8, 2, 7};
        ArrayList<Integer> result = solution.nextGreater(arr);

        // Print the result
        System.out.println(result);  // Output: [8, 8, -1, 7, 8]
    }
}
