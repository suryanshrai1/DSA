public class partitionArrPivot {
        public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int idx = 0;

        // Elements less than pivot
        for (int num : nums) {
            if (num < pivot) {
                ans[idx++] = num;
            }
        }
        // equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                ans[idx++] = num;
            }
        }

        // greater 
        for (int num : nums) {
            if (num > pivot) {
                ans[idx++] = num;
            }
        }
        return ans;
    }
}
