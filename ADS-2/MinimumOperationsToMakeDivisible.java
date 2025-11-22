class MinimumOperationsToMakeDivisible {

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int cost = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 3 != 0) {
                cost++;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeDivisible solution = new MinimumOperationsToMakeDivisible();

        int[] nums = {1, 3, 4, 9, 10};
        int result = solution.minimumOperations(nums);

        System.out.println("Minimum operations required: " + result);
    }
}
