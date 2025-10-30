public class MinNumberOperations {

    public int minNumberOperations(int[] target) {
        int n = target.length;
        int ans = target[0];
        for (int i = 1; i < n; i++) {
            ans += Math.max(target[i] - target[i - 1], 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinNumberOperations solution = new MinNumberOperations();

        // Test cases
        int[] target1 = {1, 2, 3, 2, 1};
        int[] target2 = {3, 1, 1, 2};
        int[] target3 = {3, 1, 5, 4, 2};

        System.out.println("Result 1: " + solution.minNumberOperations(target1)); // Expected: 3
        System.out.println("Result 2: " + solution.minNumberOperations(target2)); // Expected: 4
        System.out.println("Result 3: " + solution.minNumberOperations(target3)); // Expected: 7
    }
}
