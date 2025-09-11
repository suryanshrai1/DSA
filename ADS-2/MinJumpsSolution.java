public class MinJumpsSolution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0; // If array has 0 or 1 element, no jumps needed.
        if (arr[0] == 0) return -1; // Cannot move if starting position has 0 jump capacity.

        int jumps = 1;
        int maxReach = arr[0];
        int steps = arr[0];

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps; // Reached the end

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1; // Cannot reach further
                steps = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinJumpsSolution solution = new MinJumpsSolution();

        // Test example 1
        int[] arr1 = {6, 2, 4, 0, 5, 1, 1, 4, 2, 9};
        System.out.println("Minimum jumps required: " + solution.minJumps(arr1));

        // Test example 2
        int[] arr2 = {1, 1, 1, 1, 1};
        System.out.println("Minimum jumps required: " + solution.minJumps(arr2));

        // Test example 3 (Edge case: Single element)
        int[] arr3 = {0};
        System.out.println("Minimum jumps required: " + solution.minJumps(arr3));

        // Test example 4 (Edge case: Start with 0)
        int[] arr4 = {0, 1, 2};
        System.out.println("Minimum jumps required: " + solution.minJumps(arr4));
    }
}
