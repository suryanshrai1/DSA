import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IntervalMerger {
    
    /**
     * Merges overlapping intervals from a 2D array.
     * @param intervals An array of intervals where intervals[i] = [start, end]
     * @return A list of merged, non-overlapping intervals
     */
    public ArrayList<int[]> mergeOverlap(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new ArrayList<>();
        }

        // 1. Sort intervals by start time to ensure we only need to check the previous interval
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        ArrayList<int[]> mergedList = new ArrayList<>();
        
        // Start with the first interval
        mergedList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] lastMerged = mergedList.get(mergedList.size() - 1);

            // 2. Check for overlap: if current start is <= last merged end
            if (current[0] <= lastMerged[1]) {
                // Merge by extending the end time to the maximum of both
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                // 3. No overlap, so just add the interval to the list
                mergedList.add(current);
            }
        }
        return mergedList;
    }

    public static void main(String[] args) {
        IntervalMerger merger = new IntervalMerger();

        // Test Case 1: Standard overlapping intervals
        int[][] test1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Test Case 1: " + Arrays.deepToString(test1));
        printResult(merger.mergeOverlap(test1));

        // Test Case 2: Fully contained intervals
        int[][] test2 = {{1, 4}, {2, 3}};
        System.out.println("\nTest Case 2: " + Arrays.deepToString(test2));
        printResult(merger.mergeOverlap(test2));

        // Test Case 3: Multiple overlaps
        int[][] test3 = {{1, 10}, {2, 3}, {4, 5}, {6, 7}};
        System.out.println("\nTest Case 3: " + Arrays.deepToString(test3));
        printResult(merger.mergeOverlap(test3));
    }

    private static void printResult(ArrayList<int[]> result) {
        System.out.print("Merged Result: [");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(Arrays.toString(result.get(i)) + (i < result.size() - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}