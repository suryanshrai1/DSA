import java.util.Arrays;

class MinDifferenceCalculator {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        // Initial answer: difference between the largest and smallest elements
        // if we just consider the original extremes after applying operations
        int ans = arr[n - 1] - arr[0];

        // Iterate through the array to find the optimal solution
        for (int i = 1; i < n; i++) {
            // If decreasing arr[i] by k results in a negative height, skip this iteration
            if (arr[i] - k < 0) {
                continue;
            }

            // Calculate potential new minimum and maximum values
            // The minimum could be the first element increased by k, or the current element decreased by k
            int min_val = Math.min(arr[0] + k, arr[i] - k);

            // The maximum could be the last element decreased by k, or the previous element increased by k
            int max_val = Math.max(arr[n - 1] - k, arr[i - 1] + k);

            ans = Math.min(ans, max_val - min_val);
        }
        return ans;
    }

    public static void main(String[] args) {
        // Example input
        int[] arr = {1, 5, 8, 10};
        int k = 2;

        // Create an instance of the MinDifferenceCalculator
        MinDifferenceCalculator calculator = new MinDifferenceCalculator();

        // Call the method and print the result
        int result = calculator.getMinDiff(arr, k);
        System.out.println("The minimum difference is: " + result);
    }
}
