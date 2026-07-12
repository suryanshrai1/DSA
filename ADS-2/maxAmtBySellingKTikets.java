import java.util.Collections;
import java.util.PriorityQueue;

public class maxAmtBySellingKTikets {
        public int maxAmount(int[] arr, int k) {
        long MOD = 1000000007;
        
        // Create a max heap using Collections.reverseOrder()
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Populate the heap with all available tickets
        for (int tickets : arr) {
            pq.add(tickets);
        }
        
        long totalEarnings = 0;
        
        // Sell up to k tickets greedily
        while (k > 0 && !pq.isEmpty()) {
            int currentMaxPrice = pq.poll();
            
            // Add current highest ticket price to earnings
            totalEarnings = (totalEarnings + currentMaxPrice) % MOD;
            
            // If the seller still has tickets left, push the updated count back
            if (currentMaxPrice - 1 > 0) {
                pq.add(currentMaxPrice - 1);
            }
            
            k--;
        }
        return (int) totalEarnings;
    }
}
