import java.util.*;

public class minDeletionsMakeArrSorted {
    public int minDeletions(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> tail = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = tail.size();
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (tail.get(mid) < arr[i]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (lo == tail.size()) {
                tail.add(arr[i]);
            } else {
                tail.set(lo, arr[i]);
            }
        }
        return n - tail.size();
    }
}
