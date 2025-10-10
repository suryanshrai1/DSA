public class MaxEnergyCollector {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int res = Integer.MIN_VALUE;
        for (int i = n - 1; i >= n - k; i--) {
            int sum = 0;
            for (int j = i; j >= 0; j -= k) {
                sum += energy[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxEnergyCollector collector = new MaxEnergyCollector();

        // Example input
        int[] energy = {5, -2, 3, 1, -1, 2};
        int k = 2;

        int result = collector.maximumEnergy(energy, k);
        System.out.println("Maximum energy: " + result);
    }
}
