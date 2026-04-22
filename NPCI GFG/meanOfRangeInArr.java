import java.util.ArrayList;

public class meanOfRangeInArr {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        long[] prefixSum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        ArrayList<Integer> results = new ArrayList<>();

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            long sum = prefixSum[r + 1] - prefixSum[l];
            // Calculate number of elements in the range
            int count = r - l + 1;

            int mean = (int) (sum / count);
            results.add(mean);
        }
        return results;
    }
}
