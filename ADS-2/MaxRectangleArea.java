import java.util.Stack;

public class MaxRectangleArea {
    
    // Function to calculate the maximum area of a rectangle formed by 1's
    static int maxArea(int mat[][]) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        // Initialize the height array for histogram representation
        int[] height = new int[cols];
        int maxArea = 0;
        
        // Process each row
        for (int i = 0; i < rows; i++) {
            // Update the heights for histogram based on the current row
            for (int j = 0; j < cols; j++) {
                height[j] = (mat[i][j] == 0) ? 0 : height[j] + 1;
            }
            
            // Calculate the maximum area in the current histogram (using the stack method)
            maxArea = Math.max(maxArea, maxHistogramArea(height));
        }
        
        return maxArea;
    }
    
    // Helper function to calculate the maximum area of a histogram using a stack
    private static int maxHistogramArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;
        
        while (index < height.length) {
            // If this bar is higher than the bar at stack top, push it to the stack
            if (stack.isEmpty() || height[index] >= height[stack.peek()]) {
                stack.push(index++);
            } else {
                // Calculate the area of the rectangle with stack top as the smallest (or minimum height) bar
                int topOfStack = stack.pop();
                int area = height[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        // Now, pop the remaining bars from stack and calculate area
        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = height[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test case 1
        int[][] mat1 = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };
        System.out.println("Maximum Rectangle Area (Test Case 1): " + maxArea(mat1));  // Output: 8

        // Test case 2
        int[][] mat2 = {
            {0, 1, 1},
            {1, 1, 1},
            {0, 1, 1}
        };
        System.out.println("Maximum Rectangle Area (Test Case 2): " + maxArea(mat2));  // Output: 6

        // Test case 3 (All 0's)
        int[][] mat3 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println("Maximum Rectangle Area (Test Case 3): " + maxArea(mat3));  // Output: 0

        // Test case 4 (All 1's)
        int[][] mat4 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        System.out.println("Maximum Rectangle Area (Test Case 4): " + maxArea(mat4));  // Output: 6
    }
}
