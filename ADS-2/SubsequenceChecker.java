import java.util.HashMap;
import java.util.Map;

class SubsequenceChecker {
    public boolean isPossible(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> endCount = new HashMap<>();
        for (int num : arr) {
            if (freq.get(num) == 0) {
                continue;
            }
            freq.put(num, freq.get(num) - 1);

            if (endCount.getOrDefault(num - 1, 0) > 0) {
                endCount.put(num - 1, endCount.get(num - 1) - 1);
                endCount.put(num, endCount.getOrDefault(num, 0) + 1);
            } else {
                boolean possible = true;
                for (int i = 1; i < k; i++) {
                    if (freq.getOrDefault(num + i, 0) == 0) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    for (int i = 1; i < k; i++) {
                        freq.put(num + i, freq.get(num + i) - 1);
                    }
                    endCount.put(num + k - 1, endCount.getOrDefault(num + k - 1, 0) + 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SubsequenceChecker checker = new SubsequenceChecker();
        
        // Test case 1
        int[] arr1 = {1, 2, 3, 3, 4, 5};
        int k1 = 3;
        System.out.println(checker.isPossible(arr1, k1)); // Expected output: true
        
        // Test case 2
        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 4;
        System.out.println(checker.isPossible(arr2, k2)); // Expected output: true
        
        // Test case 3
        int[] arr3 = {1, 2, 3, 4, 4, 5};
        int k3 = 3;
        System.out.println(checker.isPossible(arr3, k3)); // Expected output: false
    }
}
