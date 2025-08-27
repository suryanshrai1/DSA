import java.util.*;

class CapacityScheduler {
    static int leastWeightCapacity(int[] weights, int n, int d) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = (left + right) / 2, need = 1, curr = 0;

            for (int i = 0; i < n; i++) {
                if (curr + weights[i] > mid) {
                    curr = 0;
                    need++;
                }
                curr += weights[i];
            }

            if (need > d)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) {
        // Sample test case
        int[] weights = {10, 20, 30, 40};
        int n = weights.length;
        int d = 2;

        int result = leastWeightCapacity(weights, n, d);
        System.out.println("Least weight capacity to ship in " + d + " days: " + result);
    }
}
