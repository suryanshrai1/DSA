public class MinOperationsCalculator1 {

    public int minOperations(int[] nums, int k) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return (int)(sum % k);
    }

    public static void main(String[] args) {
        MinOperationsCalculator1 calculator = new MinOperationsCalculator1();

        int[] nums = {1, 2, 3, 4, 5};
        int k = 4;

        int result = calculator.minOperations(nums, k);
        System.out.println("Minimum operations: " + result);
    }
}
