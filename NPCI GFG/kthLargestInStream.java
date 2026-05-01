import java.util.*;

public class kthLargestInStream {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);

            // Keep only the k largest elements in the heap
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // If we have fewer than k elements, output -1
            if (minHeap.size() < k) {
                result.add(-1);
            } else {
                // The top of the min-heap is the kth largest element
                result.add(minHeap.peek());
            }
        }
        return result;
    }
}
