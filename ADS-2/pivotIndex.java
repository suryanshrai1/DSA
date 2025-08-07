public class pivotIndex {
    public static int pivotInd(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            rightSum -= val;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += val;
        }
        return -1;
    }

    public static void main(String[] args) {
        pivotIndex pv = new pivotIndex();
        int[] nums = {1,7,3,6,5,6};

        int res = pivotInd(nums);
        System.out.println(res);

    }
}