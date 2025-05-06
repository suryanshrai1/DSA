class ArrayTransformer {
    public int[] transformArrayBasedOnIndices(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[nums[i]];
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayTransformer transformer = new ArrayTransformer();
        
        // Example input
        int[] nums = {0, 2, 1, 5, 3, 4};
        
        // Transform the array
        int[] result = transformer.transformArrayBasedOnIndices(nums);
        
        // Print the result
        System.out.print("Resulting array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}