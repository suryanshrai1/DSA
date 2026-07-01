public class MaxSubarraySumByRemovingAtMostOne {
        public int maxSumSubarray(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }

        int maxNoSkip = arr[0];
        int maxOneSkip = arr[0];
        int overallMax = arr[0];

        for (int i = 1; i < n; i++) {
            // maxOneSkip can be:
            maxOneSkip = Math.max(maxNoSkip, maxOneSkip + arr[i]);

            maxNoSkip = Math.max(arr[i], maxNoSkip + arr[i]);

            overallMax = Math.max(overallMax, Math.max(maxNoSkip, maxOneSkip));
        }
        return overallMax;
    }
}
