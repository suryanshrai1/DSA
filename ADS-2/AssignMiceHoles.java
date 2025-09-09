import java.util.Arrays;

public class AssignMiceHoles {
    public int assignHole(int[] mice, int[] holes) {
        Arrays.sort(mice);
        Arrays.sort(holes);

        int maxTime = 0;
        // Calculate the maximum absolute difference
        for (int i = 0; i < mice.length; i++) {
            maxTime = Math.max(maxTime, Math.abs(mice[i] - holes[i]));
        }
        return maxTime;
    }

    public static void main(String[] args) {
        AssignMiceHoles solution = new AssignMiceHoles();

        int[] mice = { 4, -4, 2 };
        int[] holes = { 4, 0, 5 };

        int result = solution.assignHole(mice, holes);
        System.out.println("Maximum time required: " + result);
    }
}
