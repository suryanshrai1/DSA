public class stockWithTransactionFee {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        
        int hold = -arr[0];  // holding stock
        int cash = 0;        // not holding stock
        
        for (int i = 1; i < n; i++) {
            int newHold = Math.max(hold, cash - arr[i]);
            int newCash = Math.max(cash, hold + arr[i] - k);
            
            hold = newHold;
            cash = newCash;
        }
        return cash; 
    }
}