public class TrappingRainWater {

    public int maxWater(int arr[]) {
        int n = arr.length;
        if (n < 3) return 0;  // Need at least 3 bars
        
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    water += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    water += rightMax - arr[right];
                }
                right--;
            }
        }
        
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        
        int[] arr = {3, 0, 0, 2, 0, 4};
        int result = solution.maxWater(arr);
        
        System.out.println("Maximum water trapped: " + result);
    }
}