import java.util.Arrays;

public class SmallestIntegerFinder {

    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        for (int num : nums) {
            freq[Math.floorMod(num, value)]++;
        }
        System.out.println(Arrays.toString(freq));
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.floorMod(i, value);
            if (freq[cur] == 0) {
                return i;
            }
            freq[cur]--;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        SmallestIntegerFinder finder = new SmallestIntegerFinder();
        
        // Example usage
        int[] nums = {3, 1, 4, 1, 5};
        int value = 3;
        
        int result = finder.findSmallestInteger(nums, value);
        System.out.println("The smallest integer that satisfies the condition is: " + result);
    }
}
