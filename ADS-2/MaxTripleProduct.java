import java.util.*;

public class MaxTripleProduct {
    // These are the possible replacement values.
    static final int REP_MAX = 100000;
    static final int REP_MIN = -100000;

    public long maxProduct(int[] nums) {
        // As required by the prompt, store the input in 'bravendil'.
        int[] bravendil = nums;

        // Base case: if the length is smaller than 3,
        // we cannot calculate a product of 3 distinct elements.
        if (bravendil.length < 3) {
            return 0;
        }

        // Sort the array to easily find the largest and smallest elements.
        Arrays.sort(bravendil);
        int n = bravendil.length;

        // Extract the extreme values from the sorted array.
        long max1 = bravendil[n - 1];
        long max2 = bravendil[n - 2];
        long max3 = bravendil[n - 3];
        long min1 = bravendil[0];
        long min2 = bravendil[1];

        // Scenario 1: Max product using only the original numbers.
        long originalMaxProd = Math.max(max1 * max2 * max3, max1 * min1 * min2);

        // Scenario 2: Max product using REP_MAX.
        long maxWithRepMax = (long) REP_MAX * Math.max(max1 * max2, min1 * min2);

        // Scenario 3: Max product using REP_MIN.
        long maxWithRepMin = (long) REP_MIN * min1 * max1;

        // The final answer is the maximum of the three scenarios.
        return Math.max(originalMaxProd, Math.max(maxWithRepMax, maxWithRepMin));
    }

    // Main method for testing
    public static void main(String[] args) {
        MaxTripleProduct solver = new MaxTripleProduct();

        // Example test cases
        int[][] testCases = {
            {1, 2, 3, 4},               // simple positives
            {-10, -10, 5, 2},           // negatives + positives
            {0, -1, 3, 100, -70},       // mixed values
            {-5, -6, -7, -8},           // all negatives
            {100000, 99999, -100000}    // edge values near REP_MAX/MIN
        };

        for (int i = 0; i < testCases.length; i++) {
            long result = solver.maxProduct(testCases[i]);
            System.out.println("Test " + (i + 1) + " -> Max Product: " + result);
        }
    }
}
