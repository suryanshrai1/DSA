import java.util.*;

public class RainAvoider {

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        HashMap<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                res[i] = 1; // Default dry day assignment, may be replaced later
            } else {
                int lake = rains[i];
                if (lastRain.containsKey(lake)) {
                    Integer dryDay = dryDays.higher(lastRain.get(lake));
                    if (dryDay == null)
                        return new int[0]; // No valid dry day, flooding occurs
                    res[dryDay] = lake; // Dry the lake before it rains again
                    dryDays.remove(dryDay);
                }
                res[i] = -1; // It rained on this day
                lastRain.put(lake, i); // Update last rain day for the lake
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RainAvoider solver = new RainAvoider();

        // Example input
        int[] rains = {1, 2, 0, 0, 2, 1};

        int[] result = solver.avoidFlood(rains);

        // Output the result
        if (result.length == 0) {
            System.out.println("Flooding is unavoidable.");
        } else {
            System.out.println("Result:");
            System.out.println(Arrays.toString(result));
        }
    }
}
