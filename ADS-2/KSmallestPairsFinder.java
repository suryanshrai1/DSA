import java.util.*;

public class KSmallestPairsFinder {

    // Method to find k pairs with the smallest sums
    public static ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || k == 0)
            return result;

        // Min-heap to store (sum, i, j)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Initialize heap with pairs (arr1[i] + arr2[0], i, 0)
        for (int i = 0; i < Math.min(arr1.length, k); i++) {
            minHeap.offer(new int[]{arr1[i] + arr2[0], i, 0});
        }

        // Extract k smallest pairs
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1], j = top[2];

            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(arr1[i]);
            pair.add(arr2[j]);
            result.add(pair);

            // Push the next pair from arr2
            if (j + 1 < arr2.length) {
                minHeap.offer(new int[]{arr1[i] + arr2[j + 1], i, j + 1});
            }
        }

        return result;
    }

    // Main method to test
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 7, 11};
        int[] arr2 = {2, 4, 6};
        int k = 3;

        ArrayList<ArrayList<Integer>> result = kSmallestPair(arr1, arr2, k);
        System.out.println("Test Case 1:");
        System.out.println("The " + k + " pairs with the smallest sums are:");
        for (ArrayList<Integer> pair : result) {
            System.out.println(pair);
        }

        // Test Case 2
        int[] arr3 = {1, 3};
        int[] arr4 = {2, 4};
        int k2 = 2;

        ArrayList<ArrayList<Integer>> result2 = kSmallestPair(arr3, arr4, k2);
        System.out.println("\nTest Case 2:");
        System.out.println("The " + k2 + " pairs with the smallest sums are:");
        for (ArrayList<Integer> pair : result2) {
            System.out.println(pair);
        }
    }
}
