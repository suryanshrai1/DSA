import java.util.ArrayList;
import java.util.Arrays;

public class RangeCountQuery {

    // Helper function to count elements less than or equal to val
    private static int countLessOrEqual(int[] arr, int val) {
        int left = 0, right = arr.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= val) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }

    // Helper function to count elements strictly less than val
    private static int countLessThan(int[] arr, int val) {
        int left = 0, right = arr.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < val) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }

    // Main logic to count elements in given ranges
    public static ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr); // Sort the array
        ArrayList<Integer> results = new ArrayList<>();

        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            int count = countLessOrEqual(arr, b) - countLessThan(arr, a);
            results.add(count);
        }
        return results;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int[][] queries = {
            {1, 5},
            {4, 10},
            {6, 11}
        };

        ArrayList<Integer> result = cntInRange(arr, queries);

        System.out.println("Count of elements in each range:");
        for (int count : result) {
            System.out.println(count);
        }
    }
}
