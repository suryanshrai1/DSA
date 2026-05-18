public class maxSum {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int maxSum(int n) {
        // Base case: n is 0 or 1
        if (n == 0 || n == 1) return n;

        if (memo.containsKey(n)) return memo.get(n);

        int brokenSum = maxSum(n / 2) + maxSum(n / 3) + maxSum(n / 4);

        int result = Math.max(n, brokenSum);
        memo.put(n, result);
        
        return result;
    }
}
