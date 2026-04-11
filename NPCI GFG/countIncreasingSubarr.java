public class cntIncreasingSubarr {
    public int countIncreasing(int[] arr) {
        int n = arr.length;
        int totalCount = 0;
        int len = 1;

        for (int i = 1; i < n; i++) {
            // Check if the sequence is strictly increasing
            if (arr[i] > arr[i - 1]) {
                len++;
            } else {
                // Calculate subarrays for the previous sequence
                totalCount += (len * (len - 1)) / 2;
                len = 1; // Reset length
            }
        }
        totalCount += (len * (len - 1)) / 2;
        return totalCount;
    }
}
