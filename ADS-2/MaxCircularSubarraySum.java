public class MaxCircularSubarraySum {

    public static int maxCircularSum(int arr[]) {
        int totalSum = 0;

        int maxEnding = arr[0], maxSoFar = arr[0];
        int minEnding = arr[0], minSoFar = arr[0];

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];

            if (i > 0) {
                maxEnding = Math.max(arr[i], maxEnding + arr[i]);
                maxSoFar = Math.max(maxSoFar, maxEnding);

                minEnding = Math.min(arr[i], minEnding + arr[i]);
                minSoFar = Math.min(minSoFar, minEnding);
            }
        }

        // If all numbers are negative
        if (maxSoFar < 0) {
            return maxSoFar;
        }

        // Maximum of normal and circular subarray sum
        return Math.max(maxSoFar, totalSum - minSoFar);
    }

    public static void main(String[] args) {
        int[] arr1 = {8, -8, 9, -9, 10, -11, 12};
        int[] arr2 = {10, -3, -4, 7, 6, 5, -4, -1};
        int[] arr3 = {5, -2, 3, 4};

        System.out.println(maxCircularSum(arr1)); // 22
        System.out.println(maxCircularSum(arr2)); // 23
        System.out.println(maxCircularSum(arr3)); // 12
    }
}
