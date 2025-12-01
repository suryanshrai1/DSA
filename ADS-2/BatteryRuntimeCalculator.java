import java.util.Arrays;

public class BatteryRuntimeCalculator {

    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum = 0;
        for (int a : batteries)
            sum += a;

        int k = 0, len = batteries.length;

        while (batteries[len - 1 - k] > sum / (n - k)) {
            sum -= batteries[len - 1 - k];
            k++;
        }
        return sum / (n - k);
    }

    public static void main(String[] args) {
        BatteryRuntimeCalculator calc = new BatteryRuntimeCalculator();

        int n = 3;
        int[] batteries = {3, 3, 3};

        long result = calc.maxRunTime(n, batteries);

        System.out.println("Maximum running time for all " + n + " computers: " + result);
    }
}
