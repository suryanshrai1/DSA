import java.util.HashMap;

public class SubarrayXORCounter {

    public static long subarrayXor(int arr[], int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        int prefixXor = 0;

        for (int num : arr) {

            prefixXor ^= num;

            // If prefixXor itself equals k
            if (prefixXor == k) {
                count++;
            }

            // Check if there exists a prefixXor ^ k
            int required = prefixXor ^ k;
            if (map.containsKey(required)) {
                count += map.get(required);
            }

            // Store current prefixXor in map
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr1 = {4, 2, 2, 6, 4};
        int k1 = 6;
        System.out.println("Output 1: " + subarrayXor(arr1, k1)); // Expected: 4

        int[] arr2 = {5, 6, 7, 8, 9};
        int k2 = 5;
        System.out.println("Output 2: " + subarrayXor(arr2, k2)); // Expected: 2
    }
}