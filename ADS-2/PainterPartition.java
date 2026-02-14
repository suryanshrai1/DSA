class PainterPartition {

    public static boolean isFeasible(int[] arr, int k, long maxTime) {
        long currentSum = 0;
        int painters = 1;
        for (int length : arr) {
            if (length > maxTime) return false;
            if (currentSum + length <= maxTime) {
                currentSum += length;
            } else {
                painters++;
                currentSum = length;
            }
        }
        return painters <= k;
    }

    public long minTime(int[] arr, int k) {
        long low = 0;
        long high = 0;
        for (int length : arr) {
            high += length;
            if (length > low) {
                low = length;
            }
        }

        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isFeasible(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PainterPartition solution = new PainterPartition();
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        long result = solution.minTime(arr, k);
        System.out.println("Minimum time required: " + result);
    }
}
