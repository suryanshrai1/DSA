public class SneakyNumbersFinder {

    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    res[count] = nums[i];
                    count++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SneakyNumbersFinder finder = new SneakyNumbersFinder();
        int[] nums = {1, 3, 4, 2, 3, 1};
        int[] result = finder.getSneakyNumbers(nums);

        System.out.println("Sneaky numbers are:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
