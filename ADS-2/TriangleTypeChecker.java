import java.util.Scanner;

public class TriangleTypeChecker {
    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] <= nums[2] || nums[1] + nums[2] <= nums[0] || nums[0] + nums[2] <= nums[1]) {
            return "none";
        } else if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TriangleTypeChecker checker = new TriangleTypeChecker();
        System.out.println("Enter three side lengths of the triangle separated by space:");

        int[] sides = new int[3];
        for (int i = 0; i < 3; i++) {
            sides[i] = scanner.nextInt();
        }
        scanner.close();

        String result = checker.triangleType(sides);
        System.out.println("Triangle type: " + result);
    }
}

