class MaxProductSubarray {

    int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int max_so_far = arr[0];
        int min_so_far = arr[0];
        int result = max_so_far;

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];

            int temp_max = Math.max(
                    curr,
                    Math.max(max_so_far * curr, min_so_far * curr)
            );

            min_so_far = Math.min(
                    curr,
                    Math.min(max_so_far * curr, min_so_far * curr)
            );

            max_so_far = temp_max;
            result = Math.max(result, max_so_far);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxProductSubarray solution = new MaxProductSubarray();

        int[] arr = {2, 3, -2, 4};
        int result = solution.maxProduct(arr);

        System.out.println("Maximum product subarray = " + result);
    }
}
