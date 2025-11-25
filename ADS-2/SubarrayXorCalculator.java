public class SubarrayXorCalculator {

    public int subarrayXor(int[] arr) {
        int result = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            long frequency = (long)(i + 1) * (n - i);  // Number of subarrays including arr[i]
            if (frequency % 2 == 1) {                 // Only contributes if occurs odd number of times
                result ^= arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubarrayXorCalculator calculator = new SubarrayXorCalculator();

        int[] arr = {1, 2, 3};
        int result = calculator.subarrayXor(arr);

        System.out.println("Subarray XOR result: " + result);
    }
}
