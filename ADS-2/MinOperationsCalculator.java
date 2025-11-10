import java.util.Stack;

public class MinOperationsCalculator {

    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int op = 0;

        for (int val : nums) {

            while (!st.isEmpty() && st.peek() > val)
                st.pop();

            if (val == 0) {
                st.clear();
                continue;
            }

            if (st.isEmpty() || val > st.peek()) {
                st.push(val);
                op++;
            }
        }
        return op;
    }

    // Main method to test the code
    public static void main(String[] args) {
        MinOperationsCalculator calculator = new MinOperationsCalculator();

        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {0, 1, 2, 0, 3};
        int[] nums3 = {1, 1, 1, 1};
        int[] nums4 = {3, 1, 4, 0, 2, 2, 5};

        System.out.println("Min operations (nums1): " + calculator.minOperations(nums1));
        System.out.println("Min operations (nums2): " + calculator.minOperations(nums2));
        System.out.println("Min operations (nums3): " + calculator.minOperations(nums3));
        System.out.println("Min operations (nums4): " + calculator.minOperations(nums4));
    }
}
