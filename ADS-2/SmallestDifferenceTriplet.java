import java.util.Arrays;

public class SmallestDifferenceTriplet {

    static int[] smallestDiff(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[3];

        while (i < a.length && j < b.length && k < c.length) {
            int minVal = Math.min(a[i], Math.min(b[j], c[k]));
            int maxVal = Math.max(a[i], Math.max(b[j], c[k]));
            int currentDiff = maxVal - minVal;
            int currentSum = a[i] + b[j] + c[k];

            if (currentDiff < minDiff ||
               (currentDiff == minDiff && currentSum < minSum)) {
                minDiff = currentDiff;
                minSum = currentSum;
                result[0] = a[i];
                result[1] = b[j];
                result[2] = c[k];
            }

            if (minVal == a[i]) {
                i++;
            } else if (minVal == b[j]) {
                j++;
            } else {
                k++;
            }
        }

        Arrays.sort(result);
        // reverse to descending order (optional, based on requirement)
        for (int left = 0, right = result.length - 1; left < right; left++, right--) {
            int temp = result[left];
            result[left] = result[right];
            result[right] = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 10};
        int[] b = {2, 15, 20};
        int[] c = {10, 12};

        int[] result = smallestDiff(a, b, c);

        System.out.println("Triplet with smallest difference:");
        System.out.println(Arrays.toString(result));
    }
}
