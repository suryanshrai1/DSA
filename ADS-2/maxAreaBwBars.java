import java.util.List;

public class maxAreaBwBars {
        public int maxArea(List<Integer> height) {
        // Handle edge cases where no bars can be between two bars
        if (height == null || height.size() <= 2) {
            return 0;
        }
        
        int maxArea = 0;
        int left = 0;
        int right = height.size() - 1;
        
        while (left < right) {
            // Calculate the number of bars strictly between left and right
            int width = right - left - 1;
            
            // Calculate area based on the shorter of the two boundary bars
            int currentArea = Math.min(height.get(left), height.get(right)) * width;
            
            // Update maximum area found so far
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the shorter bar inward
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
