import java.util.Arrays;
import java.lang.Math;

class ChairArrangement {
    public int findMoves(int[] chairs, int[] passengers) {
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        int totalMoves = 0;
        for (int i = 0; i < chairs.length; i++) {
            totalMoves += Math.abs(chairs[i] - passengers[i]);
        }
        return totalMoves;
    }

    public static void main(String[] args) {
        ChairArrangement chairArrangement = new ChairArrangement();
        
        // Example input: chairs and passengers positions
        int[] chairs = {1, 4, 2, 10};
        int[] passengers = {3, 8, 6, 9};
        
        // Calculate and print the minimum total moves
        int result = chairArrangement.findMoves(chairs, passengers);
        System.out.println("Total moves required: " + result);
    }
}
