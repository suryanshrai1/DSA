import java.util.Stack;

public class MaxVisiblePeople {

    public int maxPeople(int[] arr) {
        int n = arr.length;
        int[] L = new int[n]; // visible to left
        int[] R = new int[n]; // visible to right

        // Left -> Monotonic stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                count += L[stack.peek()] + 1;
                stack.pop();
            }
            L[i] = count;
            stack.push(i);
        }

        // Right -> Monotonic stack
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                count += R[stack.peek()] + 1;
                stack.pop();
            }
            R[i] = count;
            stack.push(i);
        }

        // Max visible
        int maxVisible = 0;
        for (int i = 0; i < n; i++) {
            maxVisible = Math.max(maxVisible, L[i] + R[i] + 1); // +1 for self
        }

        return maxVisible;
    }

    public static void main(String[] args) {
        MaxVisiblePeople solution = new MaxVisiblePeople();

        int[] arr = {5, 3, 8, 3, 2, 5};
        int result = solution.maxPeople(arr);

        System.out.println("Maximum visible people: " + result);
    }
}
