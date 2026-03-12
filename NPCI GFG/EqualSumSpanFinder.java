public class EqualSumSpanFinder {

    public int equalSumSpan(int[] a1, int[] a2) {
        int n = a1.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = a1[i] - a2[i];
        }

        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int j = 0; j < n; j++) {
            sum += diff[j];

            if (sum == 0) {
                maxLength = j + 1;
            } else if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        EqualSumSpanFinder solution = new EqualSumSpanFinder();

        int[] a1 = {0, 1, 0, 0, 0, 0};
        int[] a2 = {1, 0, 1, 0, 0, 1};

        int result = solution.equalSumSpan(a1, a2);
        System.out.println("Longest span with same sum: " + result);
    }
}