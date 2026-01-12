import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            // Remove elements smaller than current from the back
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }

            // Add current index
            dq.addLast(i);

            // Remove elements outside the current window
            if (dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // Add max element for the current window
            if (i >= k - 1) {
                result.add(arr[dq.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        ArrayList<Integer> result = solution.maxOfSubarrays(arr, k);
        System.out.println(result);
    }
}
