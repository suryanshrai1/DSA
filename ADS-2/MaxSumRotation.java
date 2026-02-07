public class MaxSumRotation {

    static int maxSum(int[] arr) {
        int n = arr.length;
        long arrSum = 0;
        long currentSum = 0;

        // Calculate sum of array elements and initial rotation sum (R0)
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            currentSum += (long) i * arr[i];
        }

        long maxSum = currentSum;

        // Compute rotation sums using the relation
        for (int i = 1; i < n; i++) {
            currentSum = currentSum + arrSum - (long) n * arr[n - i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return (int) maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};

        int result = maxSum(arr);
        System.out.println("Maximum rotation sum is: " + result);
    }
}
