import java.util.List;
import java.util.ArrayList;

public class TriangleMinimumPathSum {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int row = n - 1; row > 0; row--) {
            for (int col = 0; col < triangle.get(row).size() - 1; col++) {
                triangle.get(row - 1).set(col, triangle.get(row - 1).get(col) + Math.min(triangle.get(row).get(col), triangle.get(row).get(col + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        // Example triangle
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));

        // Creating an instance of TriangleMinimumPathSum
        TriangleMinimumPathSum solution = new TriangleMinimumPathSum();
        
        // Calculate the minimum path sum
        int result = solution.minimumTotal(triangle);
        
        // Output the result
        System.out.println("Minimum path sum: " + result);
    }
}
