import java.util.*;

public class CollisionCounter {

    public int countCollisions(String s) {
        int i = 0;
        int j = s.length() - 1;

        // Skip all cars moving left at the start
        while (i <= j && s.charAt(i) == 'L') {
            i++;
        }

        // Skip all cars moving right at the end
        while (i <= j && s.charAt(j) == 'R') {
            j--;
        }

        int collisions = 0;

        // Count all cars that are not stationary in the middle part
        for (int k = i; k <= j; k++) {
            if (s.charAt(k) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        CollisionCounter counter = new CollisionCounter();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter car directions string (L/R/S): ");
        String s = sc.nextLine();

        int result = counter.countCollisions(s);
        System.out.println("Total collisions: " + result);

        sc.close();
    }
}
