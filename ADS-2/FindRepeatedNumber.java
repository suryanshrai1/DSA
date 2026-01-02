public class FindRepeatedNumber {

    // Method to find the repeated number in the array
    public int repeatedNTimes(int[] nums) {
        int n = nums.length - 1;
        if (nums[0] == nums[n]) {
            return nums[0];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        // Example array with a repeated element
        int[] nums = {1, 2, 3, 3};
        
        // Create an instance of FindRepeatedNumber
        FindRepeatedNumber solution = new FindRepeatedNumber();
        
        // Call the method and print the result
        System.out.println("The repeated number is: " + solution.repeatedNTimes(nums));
    }
}
