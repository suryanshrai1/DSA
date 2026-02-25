import java.util.*;

public class SortByBitsSolution {

    public int[] sortByBits(int[] arr) {
        int n = arr.length;

        PriorityQueue<Integer>[] buckets = new PriorityQueue[15];

        for (int i = 0; i < 15; i++) {
            buckets[i] = new PriorityQueue<>();
        }

        for (int num : arr) {
            buckets[Integer.bitCount(num)].add(num);
        }

        int[] ans = new int[n];
        int index = 0;

        for (int i = 0; i < 15 && index < n; i++) {
            while (!buckets[i].isEmpty()) {
                ans[index++] = buckets[i].poll();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SortByBitsSolution solution = new SortByBitsSolution();
        
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] result = solution.sortByBits(arr);

        System.out.println("Sorted by number of 1 bits:");
        System.out.println(Arrays.toString(result));
    }
}