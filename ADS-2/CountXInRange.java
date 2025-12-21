import java.util.*;

public class CountXInRange {

    public static ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> results = new ArrayList<>();

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];

            int firstIdx = findFirst(arr, l, r, x);
            if (firstIdx == -1) {
                results.add(0);
            } else {
                int lastIdx = findLast(arr, l, r, x);
                results.add(lastIdx - firstIdx + 1);
            }
        }
        return results;
    }

    // Find first occurrence of x in range [l, r]
    private static int findFirst(int[] arr, int l, int r, int x) {
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                ans = mid;
                r = mid - 1;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    // Find last occurrence of x in range [l, r]
    private static int findLast(int[] arr, int l, int r, int x) {
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                ans = mid;
                l = mid + 1;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 5, 5, 8};
        int[][] queries = {
            {0, 7, 5},
            {1, 2, 2},
            {0, 3, 7}
        };

        ArrayList<Integer> result = countXInRange(arr, queries);
        System.out.println(result); // Output: [3, 2, 0]
    }
}
