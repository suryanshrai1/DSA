
import java.util.HashMap;

public class NumEquivDominoPairs {
    public int numEquivDominoPair(int[][] dominoes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            int key = a < b ? a * 10 + b : b * 10 + a; // Integer key

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int n : map.values()) {
            if (n > 1) {
                count += n * (n - 1) / 2; // n choose 2
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumEquivDominoPairs num = new NumEquivDominoPairs();

        int[][] dominoes1 = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(num.numEquivDominoPair(dominoes1)); // Output: 1

        int[][] dominoes2 = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
        System.out.println(num.numEquivDominoPair(dominoes2)); // Output: 3
    }
}
