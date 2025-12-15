public class BalancedPartition {

    public int cntWays(int[] arr) {
        int n = arr.length;
        if (n <= 1) return n;

        int[] prefixEven = new int[n];
        int[] prefixOdd = new int[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                prefixEven[i] = (i == 0) ? arr[i] : prefixEven[i - 1] + arr[i];
                prefixOdd[i] = (i == 0) ? 0 : prefixOdd[i - 1];
            } else {
                prefixOdd[i] = (i == 0) ? arr[i] : prefixOdd[i - 1] + arr[i];
                prefixEven[i] = (i == 0) ? 0 : prefixEven[i - 1];
            }
        }

        int totalEvenSum = prefixEven[n - 1];
        int totalOddSum = prefixOdd[n - 1];
        int count = 0;

        for (int i = 0; i < n; i++) {
            int currentEvenSum = (i == 0) ? 0 : prefixEven[i - 1];
            int currentOddSum = (i == 0) ? 0 : prefixOdd[i - 1];

            int newEvenSum = currentEvenSum + (totalOddSum - prefixOdd[i]);
            int newOddSum = currentOddSum + (totalEvenSum - prefixEven[i]);

            if (newEvenSum == newOddSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        BalancedPartition solution = new BalancedPartition();
        
        int[] arr = {1, 2, 3, 4, 5, 6};  // Example array
        int result = solution.cntWays(arr);
        
        System.out.println("Number of ways to partition: " + result);
    }
}
