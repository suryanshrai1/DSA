import java.util.*;

public class minInsertDeleteToConvert {
       public int minInsAndDel(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        // Map each element of b to its index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(b[i], i);
        }
        
        // Filter array 'a' to keep only elements present in 'b', replaced by their indices in 'b'
        List<Integer> filteredIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i])) {
                filteredIndices.add(map.get(a[i]));
            }
        }
        
        // Find the length of the Longest Increasing Subsequence (LIS)
        int lisLen = findLIS(filteredIndices);
        
        // Result is Total Deletions + Total Insertions
        return (n - lisLen) + (m - lisLen);
    }
    
    // O(N log N) approach using Binary Search (Patience Sorting)
    private int findLIS(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        
        List<Integer> tails = new ArrayList<>();
        
        for (int x : list) {
            int idx = Collections.binarySearch(tails, x);
            
            // If element is not found, binarySearch returns (-(insertion point) - 1)
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            if (idx == tails.size()) {
                tails.add(x);
            } else {
                tails.set(idx, x);
            }
        }
        return tails.size();
    }
}
