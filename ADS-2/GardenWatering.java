import java.util.*;

public class GardenWatering {

    public static boolean check(int[] arr, long k, int w, long H) {
        long daysUsed = 0;
        long currentWaterEffect = 0;
        long[] waterDiff = new long[arr.length];

        for (int i = 0; i < arr.length; i++) {
            currentWaterEffect += waterDiff[i];
            long currentHeight = arr[i] + currentWaterEffect;

            if (currentHeight < H) {
                long needed = H - currentHeight;
                daysUsed += needed;
                if (daysUsed > k) return false;

                currentWaterEffect += needed;
                if (i + w < arr.length) {
                    waterDiff[i + w] -= needed;
                }
            }
        }
        return true;
    }

    public static int maxMinHeight(int[] arr, int k, int w) {
        long minH = Long.MAX_VALUE;
        long maxH = Long.MIN_VALUE;

        for (int h : arr) {
            minH = Math.min(minH, h);
            maxH = Math.max(maxH, h);
        }

        long left = minH, right = maxH + k;
        long ans = minH;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (check(arr, k, w, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;   // total watering days
        int w = 2;   // watering affects w consecutive plants

        int result = maxMinHeight(arr, k, w);
        System.out.println("Maximum minimum height: " + result);
    }
}
