class KLengthApartChecker {

    public boolean kLengthApart(int[] nums, int k) {
        final int n = nums.length;
        int last = -200;  // A sufficiently small initial index
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (i - last - 1 < k)
                    return false;
                last = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        KLengthApartChecker checker = new KLengthApartChecker();

        int[] nums = {1, 0, 0, 0, 1, 0, 0, 1};
        int k = 2;

        boolean result = checker.kLengthApart(nums, k);
        System.out.println("Are all 1s at least " + k + " positions apart? " + result);
    }
}
