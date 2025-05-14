class FIndDuplicateNo {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FIndDuplicateNo duplicateNo = new FIndDuplicateNo();
        int[] nums = {3, 1, 3, 4, 2}; // Example input
        int duplicate = duplicateNo.findDuplicate(nums);
        System.out.println("The duplicate number is: " + duplicate);
    }
}
