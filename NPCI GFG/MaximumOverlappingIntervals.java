import java.util.*;

public class MaximumOverlappingIntervals {

    public static int overlapInt(int[][] arr) {
        int n = arr.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = arr[i][0];
            end[i] = arr[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0;
        int current = 0, maxOverlap = 0;

        while (i < n && j < n) {
            // Inclusive intervals condition
            if (start[i] <= end[j]) {
                current++;
                maxOverlap = Math.max(maxOverlap, current);
                i++;
            } else {
                current--;
                j++;
            }
        }

        return maxOverlap;
    }

    public static void main(String[] args) {

        int[][] arr1 = { {1, 2}, {2, 4}, {3, 6} };
        System.out.println("Maximum Overlap (Test 1): " + overlapInt(arr1));

        int[][] arr2 = { {1, 8}, {2, 5}, {5, 6}, {3, 7} };
        System.out.println("Maximum Overlap (Test 2): " + overlapInt(arr2));
    }
}
